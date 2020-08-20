package search;

public class carpet {

	public static int[] solution(int brown, int yellow) {

		int[] answer = new int[2];
		int sum = brown + yellow;
		int y;
		
		for (int x = 1;; x++) {
			y = sum / x;
			if ((2 * x) + (2 * y) - 4 == brown && x >= y) {
				answer[0] = x;
				answer[1] = y;
				break;
			}

		}
		return answer;
	}

	public static void main(String[] args) {

		int[] answer = solution(10, 2);
		System.out.print("[");
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
			if(i==answer.length-1)continue;
			System.out.print(" ");
		}
		System.out.print("]");
	}

}
