import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        String str = arrangement;
		Stack<Character> stk = new Stack<>();
		
		stk.push(str.charAt(0));
		int answer = 0;
		
		for (int i=1; i<str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == '(')
				stk.push(ch);
			else { // ch == ')'
				stk.pop();
				if(str.charAt(i-1)=='(')
					answer += stk.size();
				else
					answer++;
			}
		}
		return answer;
    }
}