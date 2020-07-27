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

class Solution2 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //다리를 지나고 있는 트럭들을 저장할 큐
        Queue<truck> q = new LinkedList<truck>();
        //반복문을 도는 동안 큐를 변형하지 않기 위한 boolean
        boolean flag;
        //다리 위의 트럭의 총 무게
        int tw=0;
        
        //배열의 인덱스
        int i=0;
        //반복의 횟수를 알 수 없으므로 무한 반복
        while(true){
        	//다리를 모두 지난 트럭이 없으면 true, 있으면 false
            flag = true;
            for(truck t: q){
            	//트럭의 위치와 다리의 길이가 같으면 트럭이 다리를 지남
                if(t.position==bridge_length) flag = false;
                //아니면 다리를 계속 건넘
                else t.position++;
            }
            //다리를 지난 트럭이 있으면
            if(!flag) {
            	//총 무게에서 다리르 지난 트럭의 무게를 뺌
                tw-=q.peek().weight;
                //큐의 맨 앞에 저장된 값을 삭제
                //트럭은 한 번에 하나만 지날 수 있기 때문에 하나만 삭제
                q.remove();
            }
            //인덱스 값이 배열의 길이보다 작고 총 무게에 다음 트럭의 무게를 더해도 다리가 견딜 수 있는 무게라면
            if(i<truck_weights.length && tw+truck_weights[i]<=weight){
            	//트럭이 다리를 지나기 시작
                q.add(new truck(i,1,truck_weights[i]));
                //총 무게에 새로운 더함
                tw +=truck_weights[i];
                //다음 인덱스
                i++;
                
            }
            //시간 증가
            answer++;
            //만약 다리 위에 트럭이 없다면 모든 트럭이 다리를 지났음을 의미
            if(q.isEmpty()) return answer;
        }
        
    }
}

public class Pb2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과: 8
		
		//입력
		//다리의 길이
		int bridge_length=2;
		//다리가 견딜 수 있는 무게
		int weight=10;	
		//지나가야 할 트럭들의 무게
		int[] truck_weights= {7,4,5,6};
		Solution2 s = new Solution2();
		System.out.println(s.solution(bridge_length, weight, truck_weights));
	}

}
