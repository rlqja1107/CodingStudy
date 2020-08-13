package sort;

public class h_index {
	static int[] citations = { 3, 0, 6, 1, 5 };
	// static int[] citations = { 12, 11, 10, 9, 8, 1 };
	// static int[] citations = { 6, 6, 6, 6, 6, 1 };
	//static int[] citations = { 5, 5, 5, 5, 5 };
	
	// n편중 h번이상인용된 논문이 h편이상이고 나머지는 논문이 h번이하 인용되었다면
	// h의 최댓값이 이 과학자의 H-Index이다.

	public static void sort_array(int[] citations) {
		int max, temp;
		int index = 0;

		for (int i = 0; i < citations.length; i++) {
			max = -1;
			for (int j = i; j < citations.length; j++) {
				if (max < citations[j]) {
					max = citations[j];
					index = j;
				}
			}
			temp = citations[i];
			citations[i] = citations[index];
			citations[index] = temp;
		}

	}

	public static int solution(int[] citations) {
		int answer = 0;
		int find=0;
		
		sort_array(citations);

		for (int h = 0; h < citations.length; h++) {
			if (citations[h] <= h) {
				answer = h;
				break;
			}
			else find++;
		}
		if(find==citations.length) answer=find;
		
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(citations));

	}

}
