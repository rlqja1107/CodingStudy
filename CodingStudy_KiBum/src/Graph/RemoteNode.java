package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class RemoteNode {
	public static void find_node() {
		
	}
	public static int solution(int n, int[][]edge) {
		HashMap<Integer,HashSet<Integer>> map=new HashMap<Integer,HashSet<Integer>>();
		for(int i=1;i<=n;i++) {
			map.put(i,new HashSet<Integer>());
		}
		for(int i=0;i<edge.length;i++) {
			map.get(edge[i][0]).add(edge[i][1]);
			map.get(edge[i][1]).add(edge[i][0]);
		}
		HashSet<Integer> answer=new HashSet<Integer>();
		return 5;
	}
	
	public static void main(String[] args) {
		int [][] sol={{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(6,sol));

	}

}
