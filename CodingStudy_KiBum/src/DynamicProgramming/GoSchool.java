package DynamicProgramming;

import java.util.ArrayList;

public class GoSchool{
	public static int solution(int m, int n, int[][]puddles) { 	
		int sum[][]=new int[n+1][m+1];
		int flag=0;
		//물웅덩이가 있는 곳은 -1로 지정
		for(int i=0;i<puddles.length;i++) {
			sum[puddles[i][1]][puddles[i][0]]=-1;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				//index가 1인데 물웅덩이면 나머지 뒤의 웅덩이 모두 0으로
				if(i==1) {
					if(sum[i][j]==-1) {sum[i][j]=0; break;}
					else sum[i][j]=1;
				}
				//flag를 줘서 sum[j][1] -1인 곳을 한번만 허용
				else if(j==0&&flag==0) {

					if(sum[i][j]==-1) {
						sum[i][j]=0;
						flag++;
					}
					else sum[i][j]=1;
				}
				//위쪽 route와 왼쪽 route의 합을 넣음
				//물웅덩이면 0으로 초기화
				else{
					if(sum[i][j]!=-1) {
						sum[i][j]=sum[i-1][j]+sum[i][j-1];
					}
					else { sum[i][j]=0;
					}
				}
			}
		}
		return sum[n][m]%1000000007;

	}
	public static void main(String args[]) {
		int a[][]= {{2,2}};
		System.out.println(solution(4,3,a));
	}


}
