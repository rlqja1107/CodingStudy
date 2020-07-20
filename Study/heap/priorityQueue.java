import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minpriority = new PriorityQueue<>();
		Queue<Integer> maxpriority = new PriorityQueue<>(Collections.reverseOrder());
        int[] answer = new int[2];
        
        for(int i=0; i<operations.length; i++) {
			String[] split = operations[i].split(" ");
			String op = split[0];
			int num = Integer.parseInt(split[1]);
			
			if(op.equals("I")) {
				minpriority.offer(num);
				maxpriority.offer(num);
			}
			
			if(op.equals("D") && num == 1 && !maxpriority.isEmpty()) {
				int max = maxpriority.poll();
				minpriority.remove(max);
			}
			
			if(op.equals("D") && num == -1 && !minpriority.isEmpty()) {
				int min = minpriority.poll();
				maxpriority.remove(min);
			}
		}
        
        if(maxpriority.isEmpty()) {
			answer[0] = 0;
			answer[1] = 0;
		}
		else {
			answer[0] = maxpriority.poll();
			answer[1] = minpriority.poll();
		}
        
        return answer;
    }
}