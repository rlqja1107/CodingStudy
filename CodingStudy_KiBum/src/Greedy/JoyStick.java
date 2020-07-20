package Greedy;

public class JoyStick {
	public static int solution(String name) {
		int direction=1;
		int reach;

		int front_A=0,back_A=0;
		int front_reach=0,back_reach=0;
		//앞에서부터 A의 갯수세기
		for(int i=1;i<name.length();i++) {
			if(name.charAt(i)!='A') {
				front_reach=i;
				break;
			}
			front_A++;
		}
		//뒤에서부터 A의 갯수세기
		for(int i=name.length()-1;i>0;i--) {
			if(name.charAt(i)!='A') {
				back_reach=i;
				break;
			}
			back_A++;
		}
		//조이스틱 좌우버튼 결정
		if(front_A>back_A) {
			direction=-1;
			reach=name.length()-front_reach;
		}
		else {
			reach=back_reach;
		}
		int answer=0;
		int index=0;

		for(int i=0;i<=reach;i++) {
			int alpha=(int)name.charAt(index);
			//조이스틱 상하버튼을 얼마나 눌러야하는지
			if(77-alpha>=0) {
				answer+=(alpha-65);	
			}
			else { 
				answer+=(91-alpha);
			}
			index+=direction;
			if(index<0)
				index=name.length()-1;
			//조이스틱 좌 또는 우를 눌렀기 때문에 ++
			answer++;
		}
		//마지막 조이스틱 좌 또는 우는 필요없기 때문에 --
		answer--;
		return answer;

	}
	public static void main(String args[]) {
		String a="JAN";
		System.out.println(solution(a));
		System.out.println((int)'a');
	}

}
