package dp;

public class tile {
	static long[] dp = new long [100];
	
	public static long solution(int x) {
		if(x==1) return 4;
		if(x==2) return 6;
		if(dp[x]!=0) return dp[x];
		return dp[x]=solution(x-1)+solution(x-2);
		}
	
	
	public static void main(String[] args) {
		System.out.println(solution(8));
	}


}
