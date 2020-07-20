package StackQueue;
import java.util.*;
class Print{
	int locate;
	int value;
	Print(int pri,int locate){
		this.locate=locate;
		this.value=pri;
	}
}
public class Printer {
	public int solution(int[] priorities,int location) {
		
		Queue<Print> print=new LinkedList<Print>();
		Queue<Print> order=new LinkedList<Print>();
		for(int i=0;i<priorities.length;i++) {
		
			print.add(new Print(priorities[i],i));
		}
	    int when_print=0;
		while(print.size()!=0) {
			int first_print=print.peek().value;
			for(Print val: print) {
				if(first_print<val.value) { 
					break;
				}
				
			}
			print.add(print.poll());
			order.add(print.poll());
			
			
		}
		return 0;
	}
	
	public static void main(String []args) {
		
	}

}
