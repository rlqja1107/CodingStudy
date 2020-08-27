package graph;

public class ranking {

	static int[][] results = { { 4, 3 }, { 4, 2 }, { 3, 2 }, { 1, 2 }, { 2, 5 } };
	static int n = 5;

	public static int solution(int n, int[][] edge) {
		int answer = 0;

		int[][] playlist = new int[n][n];

		for (int i = 0; i < results.length; i++) {
			playlist[results[i][0] - 1][results[i][1] - 1] = 1;
			playlist[results[i][1] - 1][results[i][0] - 1] = -1;
		}

		// i=중간선수
		for (int i = 1; i < n + 1; i++) {
			// j=이긴선수
			for (int j = 1; j < n + 1; j++) {

				if (playlist[j - 1][i - 1] == 1) {
					// k=진선수
					for (int k = 1; k < n + 1; k++) {
						if (playlist[i - 1][k - 1] == 1) {
							playlist[j - 1][k - 1] = 1;
							playlist[k - 1][j - 1] = -1;
						}
					}
				}
			}
		}
		for (int[] e : playlist) {
			int cnt = 0;
			for (int i : e) {
				if (i != 0)
					cnt++;
			}
			if (cnt == n - 1)
				answer++;
		}

		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution(n, results));
	}

}
