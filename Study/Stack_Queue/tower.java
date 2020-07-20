import java.util.*;

class Solution {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stk = new Stack<>();

        for(int i=0; i<heights.length; i++) {
            stk.push(heights[i]);
        }

        for(int j=heights.length; j>0; j--) {
            int popn = 0;
            int p = stk.pop();
            while(stk.size()!=0) {
                if(stk.peek()>p)
                    break;
                stk.pop();
                popn++;
            }
            int num = stk.size();
            answer[j-1] = num;

            for(int k=0; k<popn; k++) {
                stk.push(heights[num+k]);
            }
        }
        return answer;
    }
}