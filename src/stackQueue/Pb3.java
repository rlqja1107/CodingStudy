package stackQueue;
import java.util.*;

class Progress{
	//며칠만에 완성할 수 있는지 계산한 값
    int day;
    //같이 배포되는 작업의 개수
    int count;
    
    public Progress(int day, int count){
        this.day = day;
        this.count = count;
    }
}

class Solution3 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Stack<Progress> stack = new Stack<>();
        //계산한 일 수
        int ca;
        
        for(int i=0;i<progresses.length;i++){
        	//최대 100에서 진행률을 빼고 속도로 나눠서 며칠만에 완성할 수 있는지 계산
            ca = (100-progresses[i])/speeds[i];
            //만약 스택이 비어있지 않고 스택에서 가장 마지막에 저장된 값이 계산한 일 수 보다 크거나 같다면 같이 배포해야 함
            if(!stack.isEmpty() && stack.peek().day>=ca) {
            	//같이 배포 해야하는 작업의 개수를 증가
                stack.peek().count++;
            }
            //스택이 비어있거나 택에서 가장 마지막에 저장된 값이 계산한 일 수 보다 작다면 따로 배포함
            else stack.push(new Progress(ca,1));
        }
        //스택의 사이즈 만큼 나눠서 배포함
        answer = new int[stack.size()];
        
        //스택은 후입선출이므로 마지막 값부터 저장
        for(int i= stack.size()-1;i>=0;i--){
        	//같이 배포하는 작업의 개수를 저장
            answer[i] = stack.pop().count;
        }
        
      
        return answer;
    }
}

public class Pb3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과: [2,1]
		
		//입력
		//진행 상황
		int[] progresses = {93,30,55};
		//증가율
		int[] speeds = {1,30,5};
		
		Solution3 s = new Solution3();
		int[] answer = s.solution(progresses, speeds);
		for(int a:answer) {
			System.out.println(a);
		}
	}

}
