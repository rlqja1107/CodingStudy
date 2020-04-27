package stack_queue;

import java.util.*;

public class stick {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		
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
		System.out.println(answer);
	}
}
