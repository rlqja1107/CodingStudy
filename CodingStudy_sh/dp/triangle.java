package dp;

public class triangle {
	static int[][]triangle= {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
	static int len=triangle.length;
	static int[][] dp=new int[len][len];
	static int max=0;
	
	public static int max(int a, int b) {
		return a>b ? a:b;
	}
	
	public static int solution(int[][]triangle) {
		
		dp[0][0]=triangle[0][0];
		for(int i=1;i<len;i++) {
			for(int j=0;j<=i;j++) {
			if(j==0) 
				dp[i][0]=triangle[i][0]+dp[i-1][0];
			else if(j==i)
				dp[i][j]=triangle[i][j]+dp[i-1][j-1];
			else
				dp[i][j]=max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
			
			if(i==len-1)
				max=max(dp[i][j],max);
			
			}
		}
		return max;
		
	}

	
	public static void main(String[] args) {
		System.out.println(solution(triangle));
	}
}
