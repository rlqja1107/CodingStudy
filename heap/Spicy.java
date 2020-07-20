package heap;

import java.util.*;

class Spicy {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int sum = 0;
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < scoville.length; i++) {
				pq.add(scoville[i]);
		}
		
		for (int i = 0; i < scoville.length; i++) {
			int in = pq.poll();
			if (in < K) {
				int in2 = in;
				in = pq.poll();
				sum = in2 + (in * 2);
				pq.add(sum);
				answer++;
			}
		
			if (pq.size() == 1) {
				break;
			}
		}	
		
		if (sum != 0 && sum < K)
			System.out.println(-1);
		else
			System.out.println(answer);
	}
}