package hash;

import java.util.*;

public class Camouflage {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		Map<String, Integer> hm = new HashMap<>();
		int answer = 1;
		
		for (int i = 0; i < clothes.length; i++) {
			if (hm.containsKey(clothes[i][1]))
				hm.put(clothes[i][1], hm.get(clothes[i][1])+1);
			
			else 
				hm.put(clothes[i][1], 1);
		}
				
		for (String keys : hm.keySet()) {
			answer *= (hm.get(keys) + 1);
		}
		
		answer -= 1;
		
		System.out.println(answer);
	}
}