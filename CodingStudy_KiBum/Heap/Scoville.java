package Heap;
import java.util.*;
class heap{
	public ArrayList<Integer> heap;
	private final static int ARRAY_SIZE=100000;	
	heap(){
		this(ARRAY_SIZE);
	}
	heap(int size){
		heap=new ArrayList<Integer>(size);
		heap.add(0);
	}
	public int delete() {
		int delete_value=heap.get(1);
		
		heap.set(1, heap.get(heap.size()-1));
		
		heap.remove(heap.size()-1);
		int start=1;
		while(start*2<heap.size()) {
			int min=heap.get(start*2);
			int min_index=start*2;
			if(heap.size()>start*2+1&&min>heap.get(start*2+1)) {
				min=heap.get(start*2+1);
				min_index=start*2+1;
			}
			if(heap.get(start)<min)
				break;
			
			int temp=heap.get(start);
			heap.set(start, heap.get(min_index));
			heap.set(min_index, temp);	
			start=min_index;
		}
		return delete_value;
	}
	public void insert(int value) {
		heap.add(value);
		int index=heap.size()-1;
		while(heap.get(index/2)>heap.get(index)) {
			
			int temp=heap.get(index);
			heap.set(index, heap.get(index/2));
			heap.set(index/2, temp);
			index=index/2;
		}
	}
}
public class Scoville {
	public static int solution(int []scoville,int K) {
		heap heap=new heap();
		for(int value:scoville) 
			heap.insert(value);
		
		int count=0;
		while(heap.heap.size()>1&&heap.heap.get(1)<K) {
			
			if(heap.heap.size()==2&&heap.heap.get(1)<K)
				return -1;
			
			if(heap.heap.size()<4) {
				heap.insert(heap.heap.get(1)+heap.heap.get(2));
			}
			
			else if(heap.heap.get(2)<=heap.heap.get(3)){
                heap.insert(heap.heap.get(1)+heap.heap.get(2)*2);
            }
			
            else if(heap.heap.get(2)>heap.heap.get(3)){
                heap.insert(heap.heap.get(1)+heap.heap.get(3)*2);
            }
           
			heap.delete();
			heap.delete();
			count++;
		}
		return count;
	}
	
	public static void main(String args[]) {
		int a[]= { 5};
		
		System.out.println(solution(a,7));
	}
}
