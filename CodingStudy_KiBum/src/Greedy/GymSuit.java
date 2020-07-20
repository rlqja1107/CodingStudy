package Greedy;

import java.util.Arrays;

public class GymSuit {
	public static int solution(int n, int[] lost, int[] reserve) {
		int count=n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int temp=1000;
        for(int i=0;i<lost.length;i++) {
        	for(int j=0;j<reserve.length;j++) {
        		if(lost[i]==reserve[j]) {
        			lost[i]=temp;
        			reserve[j]=-temp;
        			temp+=1000;
        			count++;
        		}
        	}
        }
        
        int lost_num=0;
        int comp=0;
        for(int i=0;i<lost.length;i++) {
        	lost_num=lost[i];
        	for(int j=0;j<reserve.length;j++) {
        		comp=lost_num-reserve[j];
        		if(comp==1||comp==-1) {
        			
        			count++;
        			reserve[j]=1000000;
        			break;
        		}
        	}
        }
        return count;
    }
	public static void main(String []args) {
		int reserve[]= {2,3};
		int lost[]= {1,2};
		System.out.println(solution(5,lost,reserve));
	}
}
