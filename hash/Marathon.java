package hash;

import java.util.*;

class Marathon {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String answer = "";
		Map<String, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < participant.length; i++) {
			if (hm.containsKey(participant[i]))
				hm.put(participant[i], hm.get(participant[i])+1);
			else		
				hm.put(participant[i], 1);
		}
						
		for (int i = 0; i < completion.length; i++) {
			if (hm.containsKey(completion[i])) 
				hm.put(completion[i], hm.get(completion[i])-1);
		}

		for(String ans : hm.keySet()) {
			if (hm.get(ans) != 0) 
				answer = ans;
		}
		
		System.out.println(answer);
	}
}