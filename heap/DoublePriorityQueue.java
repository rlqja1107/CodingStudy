package heap;

import java.util.*;

public class DoublePriorityQueue {
	public static void main(String[] args) {
		String[] operations = {"I 7", "I 5", "I -5", "D -1"};
		int[] answer = new int[2];
		int pq;
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int i = 0; i < operations.length; i++) {
			String s;
			s = operations[i];
			
			if (s.contains("D -1") && ! pq1.isEmpty()) { 
				pq = pq1.poll();
				pq2.remove(pq);
			}
			
			if (s.contains("D 1") && ! pq1.isEmpty()) {
				pq = pq2.poll();
				pq1.remove(pq);
			}
			
			if (s.contains("I ")) {
				s = s.replace("I ", "");
				int ns = Integer.parseInt(s);
				pq1.add(ns);
				pq2.add(ns);
			}
		}

		if (pq1.size() == 0 && pq2.size() == 0) {
			answer[0] = 0;
			answer[1] = 0;
		}
		
		else {
			answer[0] = pq2.poll();
			answer[1] = pq1.poll();
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}