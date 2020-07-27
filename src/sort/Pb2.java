package sort;

import java.util.*;



class Solution2 {
    
    void permutation(char[] arr, int depth, int r, Set<Integer> set) {
        if (depth == r) {
            int n = Integer.parseInt((String.valueOf(arr)).substring(0,r));
            if(n!=0 && n!=1)set.add(n);
            return ;
        }
 
        for (int i=depth; i<arr.length; i++) {
            swap(arr,depth,i);
            permutation(arr, depth + 1, r,set);
            swap(arr,depth,i);
        }
    }
    
    void swap(char[] arr, int depth, int i) {
        char temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
    public int solution(String numbers) {
        int answer = 0;
        char arr[] = numbers.toCharArray();
        Set<Integer> set = new HashSet<>();
    
        for(int i=1;i<=arr.length;i++){
            permutation(arr,0,i,set);
        }
        
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) { 
			int n = it.next();
            boolean flag = true;
            for(int i=2;i<=Math.sqrt(n);i++){
                if(n%i==0){
                    flag = false;
                    break;
                }
            }
            if(flag == true) answer++;
		}
        
        return answer;
    }
}

public class Pb2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//출력 결과: 3
		
				//입력
				//숫자(문자)
				String numbers = "17";
				Solution2 s = new Solution2();
				int answer = s.solution(numbers);
				
				//결과 출력
				System.out.println(answer);

	}

}
