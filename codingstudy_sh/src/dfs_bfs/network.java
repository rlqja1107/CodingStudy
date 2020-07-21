package dfs_bfs;

public class network {

		static int n=3;
		static int [][]computers= {{1,1,0},{1,1,1},{0,1,1}};
		static int []visited=new int[n];
		
		static int solution(int n, int [][]computers) {
			int cnt=0;
			for(int i=0;i<n;i++) {
				if(visited[i]==0) {
					cnt++;
					dfs(n,i,computers);
				}
			}
			return cnt;
		}
		
		private static void dfs(int n, int x, int[][] computers) {
			visited[x]=1;
			for(int i=0;i<n;i++) {
				int r=computers[x][i];
				if(computers[x][i]==1 && x!=i && visited[i]==0) dfs(n,i,computers);
			}
		}

		public static void main(String[] args) {
			System.out.println(solution(n,computers));
		}

	}
