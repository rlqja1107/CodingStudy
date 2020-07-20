import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] snum = new String[numbers.length];
		String answer = "";
		
		for(int i=0; i<snum.length; i++)
			snum[i] = Integer.toString(numbers[i]);
		
		Arrays.sort(snum, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if((o1+o2).compareTo(o2+o1)>0)
					return -1;
				else if((o1+o2).compareTo(o2+o1) == 0)
					return 0;
				else
					return 1;
			}
		});
		
        if(snum[0].compareTo("0") == 0)
            return "0";
        
		for(int i=0; i<snum.length; i++)
			answer += snum[i];
        
        return answer;
    }
}