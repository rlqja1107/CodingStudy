package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Camera2 {
	public static int solution(int [][]routes) {
		Arrays.sort(routes,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if((o1[1]-o1[0])>(o2[1]-o2[0]))return 1;
				else if((o1[1]-o1[0])<(o2[1]-o2[0]))return -1;
				else return 0;
			}
		});
		
		return 0;
	}
	public static void main(String []args) {
		int routes[][]= {{-20,15},{-14,-5},{-18,-13},{-5,-3}};
		System.out.println(solution(routes));
	}
}
