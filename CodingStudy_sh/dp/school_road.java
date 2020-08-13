package dp;

public class school_road {
	static int[][] puddles = { { 2, 2 } };
	static int[][] d;

	public static int solution(int m, int n, int[][] puddles) {
		d = new int[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++) {
			d[puddles[i][1]][puddles[i][0]] = -1;
		}

		d[0][1] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				
				if (d[i][j] == -1)
					d[i][j] = 0;

				else
					d[i][j] = (d[i - 1][j] + d[i][j - 1]) % 1000000007;
			}
		}

		return d[n][m];

	}

	public static void main(String[] args) {
		System.out.println(solution(4, 3, puddles));
	}

}
