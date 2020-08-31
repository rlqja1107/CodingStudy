package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
public class Immigration{
	public static int find_shortline(long[][] list){
		long min_time=10000;
		int index=0;
		for(int i=0;i<list.length;i++){
			list[i][0]+=list[i][1];

			if(min_time>=list[i][0]){
				min_time=list[i][0];
				index=i;
			}
			list[i][0]-=list[i][1];
		}
		return index;
	}
	
	public static long solution(int n,int []times){
		long time=0;
		long times_sub[][]=new long[times.length][2];
		for(int i=0;i<times.length;i++){
			times_sub[i][1]=times[i];
		}
		while(n>0){
			Arrays.sort(times_sub,new Comparator<long[]>(){
				@Override
				public int compare(long[] o1,long[] o2) {
					if(o1[0]>o2[0])return 1;
					else if(o1[0]<o2[0])return -1;
					else return 0;
				}
			});
			
			long time_pass=times_sub[0][0];
			time+=time_pass;
			for(long []i:times_sub) {
				i[0]-=time_pass;
			}
			for(int i=0;i<times_sub.length;i++) {
				if(times_sub[i][0]<=0){
					int index= find_shortline(times_sub);
					if(i==index){
						times_sub[i][0]=times_sub[i][1];
					}
					else {
						time+=times_sub[index][0];
						for(int j=0;j<times_sub.length;j++) 
							times_sub[j][0]-=times_sub[index][0];
						
						times_sub[index][0]=times_sub[index][1];
					}
					n--;
				}
			}
	
		}
		Arrays.sort(times_sub,new Comparator<long[]>(){
			@Override
			public int compare(long[] o1,long[] o2) {
				if(o1[0]>o2[0])return 1;
				else if(o1[0]<o2[0])return -1;
				else return 0;
			}
		});
		return time+times_sub[times_sub.length-1][0];

	}
	public static void main(String[] args) {
		int n=6;
		int times[]= {7,10};
		System.out.println(solution(n,times));
		
	}

}
