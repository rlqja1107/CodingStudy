package Heap;

import java.util.*;

public class moreSpicy {

	static int[] scoville = { 1, 2, 3, 9, 10, 12 };
	static int K = 7;

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		Queue<Integer> q = new PriorityQueue<>();

		for (int scovil : scoville) {
			q.add(scovil);
		}

		while (q.peek() < K) {

			if (q.size() == 1) {
				return -1;
			}
			int mix=q.poll()+(q.poll()*2);
			q.add(mix);
			answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(scoville, K));
	}

}
