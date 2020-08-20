package AllSearch;

public class Carpet {
	public static int [] solution(int brown,int yellow) {
		int yellow_width;
		int yellow_height;

		for(int i=1;i<=yellow;i++) {
			yellow_height=i;
			yellow_width=yellow/i;
			if(yellow_height*yellow_width==yellow){
				if((yellow_height+2)*(yellow_width+2)==(brown+yellow)){
					int answer[]= {yellow_width+2,yellow_height+2};
					return answer;
				}
			}
		}
		return null;
	}
	public static void main(String[] args) {
		System.out.println(solution(24,24)[0]+","+solution(24,24)[1]);
	}

}
