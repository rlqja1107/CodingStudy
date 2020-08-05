package dp;

public class school_road {
	static int[][] puddles = { { 2, 2 } };
	static int[][] dp;

	public static int solution(int m, int n, int[][] puddles) {
		dp = new int[n + 1][m + 1];

		for (int i = 0; i < puddles.length; i++) {
			dp[puddles[i][1]][puddles[i][0]] = -1;
		}

		dp[0][1] = 1;
		dp[1][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) { 

				if (dp[i][j] == -1) dp[i][j] = 0;

				else {
					if (i == 1)
						dp[i][j] = dp[i][j - 1];
					else if (j == 1)
						dp[i][j] = dp[i - 1][j];
					else
						dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 100000007;
				}

			}
		}

		return dp[n][m];

	}

	public static void main(String[] args) {
		System.out.println(solution(4, 3, puddles));

	}

}
