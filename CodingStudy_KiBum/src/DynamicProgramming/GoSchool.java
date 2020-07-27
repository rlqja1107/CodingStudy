package DynamicProgramming;

import java.util.ArrayList;

public class GoSchool{
	public static int solution(int m, int n, int[][]puddles) { 	
		int sum[][]=new int[n+1][m+1];
		int flag=0;
		//�������̰� �ִ� ���� -1�� ����
		for(int i=0;i<puddles.length;i++) {
			sum[puddles[i][1]][puddles[i][0]]=-1;
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				//index�� 1�ε� �������̸� ������ ���� ������ ��� 0����
				if(i==1) {
					if(sum[i][j]==-1) {sum[i][j]=0; break;}
					else sum[i][j]=1;
				}
				//flag�� �༭ sum[j][1] -1�� ���� �ѹ��� ���
				else if(j==0&&flag==0) {

					if(sum[i][j]==-1) {
						sum[i][j]=0;
						flag++;
					}
					else sum[i][j]=1;
				}
				//���� route�� ���� route�� ���� ����
				//�������̸� 0���� �ʱ�ȭ
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
