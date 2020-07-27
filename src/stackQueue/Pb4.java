package stackQueue;

import java.util.*;

class Printer implements Comparable<Printer>{
    int index;
    int prior;
    
    Printer(int index,int prior){
        this.index = index;
        this.prior = prior;
    }
    
    @Override
    //prior이 높은 순으로 우선 순위 큐를 정렬
    public int compareTo(Printer target){
       return this.prior <= target.prior  ? 1 : -1 ;
    }
}


class Solution4 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        //인덱스 위치
        int k=0;
        PriorityQueue<Printer> pq = new PriorityQueue<>();
       
        //우선 순위 큐에 우선 순위와 인덱스 저장 
        for(int i=0;i<priorities.length;i++) pq.offer(new Printer(i,priorities[i]));
        
        while(!pq.isEmpty()) {
        	//가장 높은 우선 순위와 배열의 우선 순위가 같다면
            if(pq.peek().prior == priorities[k]){
                //순서 증가
            	answer++;
            	//만약 배열의 위치와 순서를 알고 싶은 인덱스 위치가 같다면 반복 멈춤
                if(k == location) break;
                //우선 순위가 가장 높은 원소 삭제
                pq.poll();
            }
            
            //배열의 인덱스가 배열의 길이를 넘지 않으면서 계속 반복 하기 위해서
            k = (k+1)%(priorities.length);
        }
        return answer;
    }
}

public class Pb4 {
   
   public static void main(String[] args) {
	   //결과: 1
	   
	   //입력
	   //우선 순위 배열
	   int[] priorities = {2, 1, 3, 2};
	   //순서를 알고 싶은 배열의 위치
	   int location = 2;
      
	   Solution4 s = new Solution4();
	   int answer = s.solution(priorities, location);
     
	   System.out.println(answer);
    }
   
}