package Heap;
import java.util.*;
public class Factory {
	class inform implements Comparable<inform>{
		public int day;
		public int supplies;
		inform(int day,int supplies){
			this.day=day;
			this.supplies=supplies;
		}	

		@Override
		public int compareTo(inform o) {
			if(this.supplies>=o.supplies)
				return -1;
			else return 1;
		}
	}
	 public int solution(int stock, int[] dates, int[] supplies, int k) {
		Queue<inform> queue=new PriorityQueue<inform>();
		
//	       for(int i=0;i<supplies.length;i++)
//	    	   queue.add(new inform(dates[i],supplies[i]));
	       
	       
	     int j=0;  
	     int answer=0;
	     for(int i=0; i<k;i++) {
	    	 if(dates[j]==i) {
	    		 queue.add(new inform(dates[j],supplies[j]));
	    		 j++;
	    	 }
	    	 
	    	 if(stock==0||queue.peek().supplies+stock>k) {
	    		 answer++;
	    		 inform infor=queue.poll();
	    		 stock=infor.supplies-(i-infor.day);
	    	 }
	    	 if(k-i<=stock)
	    		 break;
	    	 
	 
	    		 
	    	 stock--;
	     }
	     return answer;
	    }
	 public static void main(String []args) {
		 int a[]= {2,1};
		 System.out.println(a[1]);
	 }

}
