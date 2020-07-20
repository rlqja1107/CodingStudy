package heap;

import java.util.*;

class Supply implements Comparable<Supply>{
    int index;
    int supply;
    
    public Supply(int index, int supply){
        this.index = index;
        this.supply = supply;
    }
    
    @Override
    public int compareTo(Supply target) {
        return this.supply > target.supply ? 1 : - 1;
    }
}

class Solution2 {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Supply> q  = new PriorityQueue<>(Collections.reverseOrder());
        int sum = stock,day=0;
        
        for(int i=0;i<supplies.length;i++){
            q.offer(new Supply(i,supplies[i]));   
            
        }
        
        while(sum<k){
            sum+=q.peek().supply+dates[q.peek().index]-day;
            System.out.println(sum);
            day = dates[q.poll().index];
            
        }
        
        
        return answer+1;
    }
}

public class Pb2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과: 2
		int stock =20,k=30;
		int[] dates= {4,10,15}, supplies= {4,5,10};
		Solution2 s = new Solution2();
		int answer = s.solution(stock, dates, supplies, k);
		System.out.println(answer);
		
	}

}
