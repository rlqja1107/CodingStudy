package BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Network {
	public static int solution(int n,int [][]computers) {
		Queue<Integer> que=new LinkedList<Integer>();
		ArrayList<Integer> check=new ArrayList<Integer>();
		//관찰대상
		int index=0;
		//네트워크 갯수
		int count=0;
		//모든 노드를 걸쳐갔는지 확인
		int flag_count=0;
		//root를
		check.add(0);
		while(flag_count!=n) {
			//자식 노드들을 queue에 담음, 자기 자신 것 제외, check에 있는 것 제외(무한루프)
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
					//안거쳐간 노드가 있으면 시작점을 그 노드로 선정
					if(!check.contains(i)) {
						check.add(i);
						index=i;
						break;
					}
					//모든 노드들이 거쳐갔으면 stop
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
