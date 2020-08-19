package Greedy;

public class gymSuit {
	static int n = 5;
	static int lost[] = { 2,4 };
	static int reserve[] = { 1,3,5 };

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int students[] = new int[n];
		int r = 0;

		for (int i = 0; i < students.length; i++)
			students[i] = 1;

		for (int i = 0; i < lost.length; i++)
			students[lost[i] - 1]--;

		for (int i = 0; i < reserve.length; i++)
			students[reserve[i] - 1]++;

		for (int i = 0; i < students.length; i++) {
			if (students[i] == 0) {
				if (i == 0) {
					if (students[i + 1] >= 2) {
						students[i]++;
						students[i + 1]--;
					}
				} else if (i == students.length - 1) {
					if (students[i - 1] >= 2) {
						students[i]++;
						students[i - 1]--;
					}
				} else {
					if (students[i + 1] >= 2) {
						students[i]++;
						students[i + 1]--;
					} else if (students[i - 1] >= 2) {
						students[i]++;
						students[i - 1]--;
					}
				}
			}
		}

		for (int i : students) {
			if (i >= 1)
				answer++;
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(n, lost, reserve));
	}

}
