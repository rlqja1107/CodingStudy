package stack_queue;

import java.util.Stack;

class Tower {    
    public static void main(String[] args) {
    	int[] heights = {6, 9, 5, 7, 4};
	    Stack<Integer> transm_t = new Stack<>();  
	    int[] answer = new int[heights.length];
	    
	    for (int i = 0; i < heights.length; i++) {
	    	transm_t.push(heights[i]);
	    }
	    
	    for (int j = heights.length; j > 0; j--) {
	    	int popNum = 0;
	    	int p = transm_t.pop();
	    	while (transm_t.size() != 0) {
	    		if (transm_t.peek() > p)
	    			break;
	    		transm_t.pop();
	    		popNum++;
	    	}
	    	int num = transm_t.size(); 
	    	
	    	answer[j-1] = num;
	    	
	    	for (int k = 0; k < popNum; k++) {
	    		transm_t.push(heights[num+k]);
	    	}
	    }
	    
	    for (int i = 0; i < answer.length; i++) {	    	
	    	System.out.print(answer[i] + " ");
	    }
    }
}