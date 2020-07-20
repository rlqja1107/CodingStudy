package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Camera {
	public static int solution(int[][]routes) {
		ArrayList<Integer []> list=new ArrayList<Integer []>();
		for(int i=0;i<routes.length;i++) {
			Integer[]temp=new Integer[3];
			for(int j=0;j<2;j++) {
				temp[j]=routes[i][j];
			}
			temp[2]=temp[1]-temp[0];
			list.add(temp);
		}
		Collections.sort(list,new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if(o1[2]>o2[2])return 1;
				else if(o1[2]<o2[2])return -1;
				else return 0;
			}
		});
		int answer=0;
		
		int start,last;
		while(list.size()>0) {
			start=list.get(0)[0];
			last=list.get(0)[1];
			for(int i=1;i<list.size();i++) {
				if((list.get(i)[0]<=start&&list.get(i)[1]>=last)||(list.get(i)[0]<=start&&
						list.get(i)[1]>=start)||(list.get(i)[0]<=last&&list.get(i)[1]>=last)) {
					list.remove(i);
					
					i--;
				}
			}
			
				list.remove(0);
				answer++;
			}
			
		
		return answer;
	}
	public static void main(String []args) {
		int routes[][]= {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println(solution(routes));
	}
}
