package hash;
import java.util.*;

class Solution1 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //선수 이름과 동명이인 인원 수
        HashMap<String, Integer> map = new HashMap<>();
      
        for(String p : participant){
        	//동명이인이 존재한다면 인원 수를 늘림
            if(map.containsKey(p))map.replace(p, map.get(p) + 1);
            //동명이인 존재하지 않으면 1명으로 추가
            else map.put(p,1);
        }
        
        for(String c: completion){
        	//완주한 이름의 인원 수를 줄임
            map.replace(c, map.get(c) - 1);
        }
        
        for(String key : map.keySet()){
        	//완주한 이름의 value 값이 0이 아니면(1이라면) 완주 하지 못한 사람이므로 반환 값에 저장 후 반복을 멈춤
            if(map.get(key) != 0){
                answer = key;
                break;
            }
        }
        
        
        return answer;
    }
}
public class Pb1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//출력: leo
		
		//입력
		//참가자
		String[] participant= {"leo", "kiki", "eden"};
		//완주한 사람
		String[] completion= {"eden", "kiki"};
		
		Solution1 s = new Solution1();
		String answer = s.solution(participant, completion);
		System.out.println(answer);
	}

}
