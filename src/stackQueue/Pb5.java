package stackQueue;

import java.util.*;

class Solution5 {
    public int solution(String arrangement) {
        int answer = 0;
        //'(' 개수가 쇠막대기의 수
        //쇠막대기 '('의 값을 저장할 stack
        Stack<Character> stack = new Stack();
        
        for(int i=0;i<arrangement.length();i++){
        	//문자열의 해당 위치의 값이 '('이면 stack에 추가
            if(arrangement.charAt(i)=='(') stack.push(arrangement.charAt(i));
            //아니면 문자열의 해당 위치 값이 ')'
            else{
            	//문자열 하나 바로 전이 '(' 값이면 절단
            	//절단 하는 '('을 제외한 갯수만큼 쇠막대기 값 증가됨
                if(arrangement.charAt(i-1) == '(') answer+=stack.size()-1;
                //문자열 하나 바로 전이 '(' 값이 아니면 쇠막대기가 끝나는 지점
                //하나 증가
                else answer++;
                //')'와 짝을 이루는 '('하나 삭제
                stack.pop();
            }
        }
        
        return answer;
    }
}

public class Pb5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과: 17
		
		//입력
		//쇠막대기를 나타내는 문자열
		String arrangement="()(((()())(())()))(())";
		
		Solution5 s = new Solution5();
		int answer = s.solution(arrangement);
		System.out.println(answer);
	}

}
