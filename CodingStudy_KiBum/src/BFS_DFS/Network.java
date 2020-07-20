package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
	public static int solution(int n,int [][]computers) {
		Queue<Integer> que=new LinkedList<Integer>();
		ArrayList<Integer> check=new ArrayList<Integer>();
		//�������
		int index=0;
		//��Ʈ��ũ ����
		int count=0;
		//��� ��带 ���İ����� Ȯ��
		int flag_count=0;
		//root��
		check.add(0);
		while(flag_count!=n) {
			//�ڽ� ������ queue�� ����, �ڱ� �ڽ� �� ����, check�� �ִ� �� ����(���ѷ���)
			for(int i=0;i<n;i++) {
				if(computers[index][i]==1&&i!=index&&!check.contains(i)) {
					que.add(i);
				}
			}
			if(que.size()>0) {
				index=que.poll();
				check.add(index);
			}
			else {
				count++;
				flag_count=0;
				for(int i=0;i<n;i++) {
					//�Ȱ��İ� ��尡 ������ �������� �� ���� ����
					if(!check.contains(i)) {
						check.add(i);
						index=i;
						break;
					}
					//��� ������ ���İ����� stop
					flag_count++;

				}
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int a[][]= {{1,1,0},{1,1,0},{0,0,1}};
		System.out.println(solution(3,a));


	}

}
