package BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;

public class Expression_N {
	public static int solution(int N,int number) {
		
		ArrayList<HashSet<Integer>> set=new ArrayList<HashSet<Integer>>();
		for(int i=0;i<=8;i++) {
			set.add(new HashSet<Integer>());
		}
		//e.x N=5
		//1:5, 2:55, 3:555 �־��ִ� ����.
		for(int i=1;i<=8;i++) {
			String temp="";
			for(int j=0;j<i;j++) {
				temp+=Integer.toString(N);
			}
			set.get(i).add(Integer.parseInt(temp));
		}
		
		for(int i=2;i<=8;i++) {
			for(int j=1;j<i;j++) {
				HashSet<Integer> curr_set=set.get(j);
				HashSet<Integer> back_set=set.get(i-j);
				for(Integer s1 : curr_set) {
					for(Integer s2:back_set) {
						set.get(i).add(s1+s2);
						set.get(i).add(s1-s2);
						try {
						set.get(i).add(s1/s2);
						}
						catch(Exception e) {
						}
						set.get(i).add(s1*s1);
					}
				}
			}
			//�ش� set�� ������ �Ǿ������� �ٷ� return
			if(set.get(i).contains(number))
				return i;
		}
		//8�� �Ѿ�� ����̱� ������ -1�� return
		return -1;
	}
	public static void main(String[] args) {
		System.out.println(solution(4,17));
		
	}

}
