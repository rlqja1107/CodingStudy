package Hash;

import java.util.*;

public class unfinishedPlayer {

	// static String[] participant = { "marina", "josipa", "nikola", "vinko",
	// "filipa" };
	// static String[] completion = { "josipa","filipa","marina" ,"nikola" };

	static String[] participant = { "mislav", "stanko", "mislav", "ana" };
	static String[] completion = { "stanko", "ana", "mislav" };

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String,Integer>player=new HashMap<String,Integer>();
		
		for(String s:participant) {
			player.put(s, player.getOrDefault(s, 0)+1);
		}
		
		for(String s:completion) {
			player.put(s, player.getOrDefault(s, 0)-1);
		}
		
		for(Map.Entry<String, Integer> e:player.entrySet()) {
			if(e.getValue()>0) {
				answer+=e.getKey();
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(participant, completion));
	}

}
