package stackQueue;
import java.util.*;

class truck{
    int index;
    int position;
    int weight;
    
    truck(int index,int position, int weight){
        this.index = index;
        this.position = position;
        this.weight = weight;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<truck> q = new LinkedList<truck>();
        boolean flag;
        int tw=0;
        
        int i=0;
        while(true){
            flag = true;
            for(truck t: q){
                if(t.position==bridge_length) flag = false;
                else t.position++;
            }
            if(!flag) {
                tw-=q.peek().weight;
                q.remove();
            }
            if(i<truck_weights.length && tw+truck_weights[i]<=weight){
                q.add(new truck(i,1,truck_weights[i]));
                tw +=truck_weights[i];
                i++;
                
            }
            answer++;
            if(q.isEmpty()) return answer;
        }
        
    }
}

public class Pb2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bridge_length=2;
		int weight=10;	
		int[] truck_weights= {7,4,5,6};
		Solution s = new Solution();
		System.out.println(s.solution(bridge_length, weight, truck_weights));
	}

}
