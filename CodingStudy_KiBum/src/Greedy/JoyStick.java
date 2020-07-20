package Greedy;

public class JoyStick {
	public static int solution(String name) {
		int direction=1;
		int reach;

		int front_A=0,back_A=0;
		int front_reach=0,back_reach=0;
		//�տ������� A�� ��������
		for(int i=1;i<name.length();i++) {
			if(name.charAt(i)!='A') {
				front_reach=i;
				break;
			}
			front_A++;
		}
		//�ڿ������� A�� ��������
		for(int i=name.length()-1;i>0;i--) {
			if(name.charAt(i)!='A') {
				back_reach=i;
				break;
			}
			back_A++;
		}
		//���̽�ƽ �¿��ư ����
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
			//���̽�ƽ ���Ϲ�ư�� �󸶳� �������ϴ���
			if(77-alpha>=0) {
				answer+=(alpha-65);	
			}
			else { 
				answer+=(91-alpha);
			}
			index+=direction;
			if(index<0)
				index=name.length()-1;
			//���̽�ƽ �� �Ǵ� �츦 ������ ������ ++
			answer++;
		}
		//������ ���̽�ƽ �� �Ǵ� ��� �ʿ���� ������ --
		answer--;
		return answer;

	}
	public static void main(String args[]) {
		String a="JAN";
		System.out.println(solution(a));
		System.out.println((int)'a');
	}

}
