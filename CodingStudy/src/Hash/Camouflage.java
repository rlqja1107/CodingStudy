package Hash;

import java.util.*;

public class Camouflage {
	public static int solution(String [][] clothes) {
		
		HashMap<String,Integer> hash=new HashMap<String,Integer>();
		//For Calculating each the number of item
		for(int i=0;i<clothes.length;i++) {
			if(!hash.containsKey(clothes[i][1])) {
				hash.put(clothes[i][1],1);
				}
			else {
				hash.replace(clothes[i][1], hash.get(clothes[i][1])+1);
			}
		}
		
		Object []num_clothes=hash.values().toArray();
		int total=1;
		
		for(int i=0;i<num_clothes.length;i++) {
			total*=(int)num_clothes[i]+1;
		}
		return total-1;
		
	}
	
	public static void main(String []args) {
	String [][] clothes= {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
	System.out.println(solution(clothes));
	}
}
