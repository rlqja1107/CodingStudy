package BinarySearch;

import java.util.*;
public class Immigration_revised {
	public static long solution(int n,int times[]) {
		Arrays.sort(times);
		long high=(long)n*(long)(times[times.length-1]);
		long low=0;
		long mid=0;
		while(high>low){
			mid=(high+low)/2;
			long man_max_number=0;
			for(int i=0;i<times.length;i++){
				man_max_number+=mid/(long)times[i];
			}
			if(man_max_number>(long)n) {
				high=mid-1;
			}
			else if(man_max_number<(long)n){
				low=mid+1;
			}
			else break;
		}
		while(true) {
			mid--;
			long man_max_number=0;
			for(int i=0;i<times.length;i++){
				man_max_number+=mid/(long)times[i];
			}
			if(man_max_number==(long)n)
				continue;
			else break;
		}
		return mid+1;
	}
	public static void main(String[] args) {
		int n=6;
		int time[]= {7,10};
		System.out.println(solution(n,time));

	}

}
