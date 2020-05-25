package Sort;

import java.util.*;


public class KthNum {
	public static int [] solution(int []array, int [][]commands) {
		int first;
		int last;
		int where;
		int []answer=new int[commands.length];
		ArrayList<Integer> temp=new ArrayList<Integer>();
		for(int i=0; i<commands.length;i++) {
			first=commands[i][0];
			last=commands[i][1];
			where=commands[i][2];
			//Arrays.copyofrange 쓰면 배열 가져올 수 있음
			for(int j=first-1;j<=last-1;j++) {
				temp.add(array[j]);
			}
			Collections.sort(temp);
			answer[i]=temp.get(where-1);
			temp.clear();
		}
		return answer;
	}
	public static void main(String []args) {
		int array[]= {1,5,2,6,3,7,4};
		int commands[][]= {{2,5,3},{4,4,1,},{1,7,3}};
		int a[]=solution(array,commands);
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}

}
