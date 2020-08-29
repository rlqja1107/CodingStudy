package Heap;

import java.util.*;

public class doublePriority {
	// static String[] operations = { "I 16", "D 1" };
	// static String[] operations = { "I 7", "I 5", "I -5", "D -1" };
	static String[] operations = { "I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1" };

	public static int[] solution(String[] operations) {
		int[] answer = new int[2];

		ArrayList<Integer> priorityq = new ArrayList<>();

		for (int i = 0; i < operations.length; i++) {

			String s = operations[i];
			if (s.contains("I")) {
				s = s.substring(2);
				int num = Integer.parseInt(s);
				priorityq.add(num);
				Collections.sort(priorityq);
			}
			if (s.contains("D") && priorityq.size() != 0) {
				s = s.substring(2);
				if (s.equals("1")) {
					priorityq.remove(priorityq.size() - 1);
				} else {
					priorityq.remove(0);
				}
			}

		}

		if (priorityq.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		} else {
			answer[0] = priorityq.get(priorityq.size() - 1);
			answer[1] = priorityq.get(0);
		}

		return answer;

	}

	public static void main(String[] args) {
		int[] r = solution(operations);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i]);
			if(i==r.length-1)continue;
			System.out.print(" , ");
		}
	}

}
