package hash;

import java.util.*;

class Marathon_2 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String answer = "";
		Map<Integer, String> hm = new HashMap<>();
		
		for (int i = 0; i < participant.length; i++) {
			hm.put(i, participant[i]);
		}
		System.out.println(hm);
		for (int i = 0; i < completion.length; i++) {
			if (hm.containsValue(completion[i]))
				hm.values().remove(completion[i]);
		}
		
		System.out.println(hm);
		
		for (int i = 0; i < participant.length; i++) {
			if (hm.get(i) != null)
				answer = hm.get(i);
		}

//		System.out.println(hm.values());
		System.out.println(answer);
	}
}