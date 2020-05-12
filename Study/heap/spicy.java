import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        int answer = 0;
        
        for(int sco : scoville)
			priorityQueue.offer(sco);

		while (priorityQueue.peek()<K) {
			if(priorityQueue.size()==1) {
				return -1;
			}
			
			int first = priorityQueue.poll();
			int second = priorityQueue.poll();
            int sv = first + second*2;
			priorityQueue.offer(sv);		
			
			answer++;			
		}
        return answer;
    }
}