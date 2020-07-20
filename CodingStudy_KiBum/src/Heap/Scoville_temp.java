package Heap;

import java.util.ArrayList;
import java.util.Collections;

public class Scoville_temp {
	public static int solution(int []scoville,int K) {
		ArrayList<Integer> array=new ArrayList<Integer>();
		for(int a:scoville)
			array.add(a);
		
		
		Collections.sort(array);
		
		
		int count=0;
		while(array.size()>0&&array.get(0)<K) {
			
			if(array.size()==1&&array.get(0)<K)
				return -1;	
			
			array.add(array.get(0)+array.get(1)*2);
			array.remove(0);
			array.remove(0);
			Collections.sort(array);
			count++;
		}
		
	return count;
		}
	
	public static void main(String args[]) {
		int a[]= {1, 2, 3, 9, 10, 12};
		
		
		System.out.println(solution(a,7));
	}
}
