package stackQueue;

import java.util.*;

class Tower{
	int height;
    int index;
    
    public Tower(int height,int index){
        this.height = height;
        this.index = index;
    }
}

class Solution1 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        //현재 Tower보다 높은 Tower들을 저장하는 Stack
        Stack<Tower> stack = new Stack<>();
        
        for(int i=0;i<heights.length;i++){
        	//stack이 비어 있으면 수신 하는 Tower 없음
            if(stack.isEmpty()) answer[i] = 0;
            else {
                while(!stack.isEmpty()){
                	//현재의 Tower보다 Stack에 저장된 Tower의 높이가 더 높다면 수신
                    if(heights[i]<stack.peek().height){
                    	//수신한 Tower의 인덱스 저장
                        answer[i] = stack.peek().index;
                        break;
                    }
                    //현재의 Tower보다 Stack에 저장된 Tower의 높이가 더 높지 않다면 저장된 Tower를 pop
                    stack.pop();
                }
            }
            //현재의 Tower를 Stack에 저장
            stack.push(new Tower(heights[i],i+1));
        }
       
        return answer;
    }
}

public class Pb1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//출력 결과: [0,0,2,2,4]
		
		//입력
		//높이
		int[] heights = {6,9,5,7,4};
		Solution1 s = new Solution1();
		int[] answer = s.solution(heights);
		
		//결과 출력
		for(int a : answer) {
			System.out.println(a);
		}
		
	}

}
