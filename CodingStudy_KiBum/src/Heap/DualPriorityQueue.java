package Heap;
import java.util.*;

public class DualPriorityQueue {
	static ArrayList<Integer> queue=new ArrayList<Integer>();
	public  static int[] solution(String [] operation){
		int answer[]=new int[2];
		for(int i=0;i<operation.length;i++) {
				
			if(operation[i].charAt(0)=='I') {
				int value=Integer.parseInt(operation[i].substring(2, operation[i].length()));
				insert(value);
			}
			else if(queue.size()==0) 
				continue;
			
			else if(queue.size()>0&&operation[i].charAt(2)=='-') 
				queue.remove(0);
			
			else queue.remove(queue.size()-1);
			
		}
		if(queue.size()<=0) {
			answer[0]=0;
			answer[1]=0;
		}
		else {
			answer[0]=queue.get(queue.size()-1);
			answer[1]=queue.get(0);
		}
		return answer;
	}
	private static void insert(int val) {
		if(queue.size()<=0)
			queue.add(val);
		else {
		int first=0;
		int last=queue.size();
		int middle=(first+last)/2;
		while(last-first>1) {
			
			if(queue.get(middle)>val)
				last=middle;
				
			else first=middle;
			
			middle=(first+last)/2;
		}
		if(queue.get(first)>val) 
			queue.add(first,val);
		else queue.add(first+1,val);
	}
		}
	
	public static void main(String []args) {
		String []a={"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		System.out.println(solution(a)[0]);
		System.out.println(solution(a)[1]);
		
	}
}
