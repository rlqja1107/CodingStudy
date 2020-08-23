package Hash;

import java.util.*;

public class camouflage {
	//static String[][] clothes = { { "yellow_hat", "headgear" }, { "blue_sunglasses", "eyewear" },
	//		{ "green_turban", "headgear" } };
	
	static String[][] clothes = { { "crow_mask", "face" }, { "blue_sunglasses", "face" },
			{ "smoky_makeup", "face" } };

	public static int solution(String[][] clothes) {
		int answer = 1;
		
		Map<String,Integer>change=new HashMap<String,Integer>();
		
		for(int i=0;i<clothes.length;i++) {
			change.put(clothes[i][1], change.getOrDefault(clothes[i][1], 0)+1);
		}
		
		
		for(String key:change.keySet()) {
			answer*=change.get(key)+1;
		}
		
		return answer-1;
	}

	public static void main(String[] args) {
		System.out.println(solution(clothes));
	}

}
