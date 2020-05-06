import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int answer = 1;
        
        for(int i=0; i<clothes.length; i++) {
			String cloth = clothes[i][1];
			if(map.containsKey(cloth))
				map.put(cloth, map.get(cloth)+1);
			else
				map.put(cloth, 2);
		}
		
		for(String key : map.keySet())
			answer *= map.get(key);
		
		answer--;
        
        return answer;
    }
}