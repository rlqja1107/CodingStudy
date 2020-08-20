package Sort;

import java.util.Arrays;

public class HIndex {
	public static int solution(int []citations) {
		Arrays.sort(citations);
		for(int i=citations.length-1;i>=0;i--){
			if(citations[i]<=(citations.length-i)) {
				return Math.max(citations[i],citations.length-i-1);
			}
		}
		return citations.length;
	}
	public static void main(String[] args) {
		int []problem= {22,42};
		System.out.println(solution(problem));

	}

}
