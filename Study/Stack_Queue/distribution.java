import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {		
		Queue<Integer> finish = new LinkedList<>();
		Queue<Integer> ans = new LinkedList<>();
		
		for(int i=0; i<progresses.length; i++) {
			int day = 0;
			while(progresses[i]<100) {
				progresses[i] += speeds[i];
				day++;
			}
			finish.offer(day);
		}
		
		while(finish.size()>0) {
			int de = finish.poll();
			int count = 1;
			int size = finish.size();
			for (int i=0; i<size; i++) {
				if(de<finish.peek())
					break;
				else {
					count++;
					finish.poll();
				}
			}
			ans.offer(count);
		}
		
		int[] answer = new int[ans.size()];
		for(int i=0; i<answer.length; i++)
			answer[i] = ans.poll();	
        return answer;
    }
}