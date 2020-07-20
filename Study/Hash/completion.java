import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        for(String p : participant) {
			if(map.containsKey(p))
				map.put(p, map.get(p)+1);
			else
				map.put(p, 1);
		}
		
		for(String cmp : completion)
			if(map.containsKey(cmp))
				map.put(cmp, map.get(cmp)-1);
		
		for(String p : map.keySet()) 
			if(map.get(p) != 0) 
				answer = p;

        return answer;
    }
}