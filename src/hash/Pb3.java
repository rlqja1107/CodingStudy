package hash;
import java.util.*;

class Solution3 {
    public int solution(String[][] clothes) {
    	//곱셈을 위해 초기 값을 1로 설정
        int answer = 1;
        //옷의 종류와 이름을 저장할 hash map 생성
        //종류에 해당하는 옷의 개수가 몇 개일지 모르는 상황이므로 array list 사용
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String[] c : clothes){
        	//옷의 종류가 존재하면 array list에 옷을 추가
            if(map.containsKey(c[1])) map.get(c[1]).add(c[0]);
            //옷의 종류가 추가되어 있지 않다면
            else {
            	//옷의 종류를 저장할 array list 생성
                ArrayList<String> array = new ArrayList<>();
                //옷의 이름을 array list에 추가
                array.add(c[0]);
                //hash에 옷의 종류와 배열 추가
                map.put(c[1],array);
            }
        }
        
        for(String s : map.keySet()){
            //옷의 종류에 해당하는 개수보다 1개 많게 하여 반환 값에 곱함
            answer *= (map.get(s).size()+1);
        }
        
        //모두 해당하지 않을 경우 하나를 빼고 반환
        return --answer;
    }
}

public class Pb3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과:5
		//입력
		//옷의 종류와 이름
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		Solution3 s = new Solution3();
		int answer = s.solution(clothes);
		System.out.println(answer);
	}

}
