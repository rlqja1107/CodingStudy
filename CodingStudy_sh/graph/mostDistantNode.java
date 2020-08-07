package graph;

import java.util.*;

public class mostDistantNode {
	static int vertex[][] = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
	static Queue<Integer> q;
	static int visited[];
	static int cnt[];
	static int answer;

	public static int solution(int n, int[][] edge) {
		cnt=new int[n+1];
		
		int max=0;
		
		// 인접리스트로 표현
		ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <=n; i++) { 
			g.add(new ArrayList<Integer>());
		}

		for (int i = 0; i <edge.length; i++) { 
			g.get(edge[i][0]).add(edge[i][1]);
			g.get(edge[i][1]).add(edge[i][0]);
		}

		q = new LinkedList<>();
		visited = new int[n+1];
		q.add(1);
		
		while (!q.isEmpty()) {
			int num= q.poll(); 
			visited[num]=1;
			for (int i = 0; i < g.get(num).size(); i++) {
				int f=g.get(num).get(i);
				if(visited[f]==0) {
					 cnt[f]=cnt[num]+1;
					 visited[f]=1;
					 q.add(f);
				}
			}	
		}
		
		for(int m:cnt) {
			max=max<m?m:max; 
		}
		for(int c:cnt) {
			if(c==max)answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(6,vertex));
		
	}

}
