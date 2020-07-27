package stackQueue;
import java.util.*;
class Stock{
    int index;
    int price;
    
    public Stock(int index,int price){
        this.index = index;
        this.price = price;
    }
}

class Solution6 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        //가격이 떨어지지 않은 주식을 저장할 stack
        Stack<Stock> stack = new Stack();
        
        for(int i=0;i<prices.length;i++){
            answer[i]=0;
            //stack이 비어있지 않을 동안
            while(!stack.isEmpty()){ 
            	//스택에 저장된 주식의 가격이 현재 가격보다 높다면 주식이 가격이 떨어진 것을 의미
                if(stack.peek().price>prices[i]){
                	//현재보다 높았던 주식에 해당하는 answer 위치에 현재 인덱스에서 현재보다 높았던 주식의 인덱스 값을 빼면 얼마만에 떨어진 것인지 계산 가능
                    answer[stack.peek().index] = i - stack.peek().index;
                    stack.pop();
                }
                //아니면 stack에 저장된 주식의 가격들이 현재 보다 낮기 때문에 주식 가격이 떨어지지 않았음을 의미함으로 반복문을 실행하지 않아도 됨
                else break;
            }
            //스택에 현재 값을 저장
            stack.push(new Stock(i,prices[i]));
        }
        //answer의 값이 0이면 끝까지 가격이 떨어지지 않았음을 의미
        for(int i=0;i<answer.length;i++){
        	//해당 인덱스에서 가격 배열의 길이의 차이가 지속된 시간을 나타냄
            if(answer[i] == 0) answer[i] = prices.length -i-1;
        }
        
        return answer;
    }
}
public class Pb6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과: [4, 3, 1, 1, 0]
		
		//입력
		//가격
		int[] prices= {1, 2, 3, 2, 3};
		
		Solution6 s = new Solution6();
		int[] answer = s.solution(prices);
		for(int a:answer) {
			System.out.println(a);
		}

	}

}
