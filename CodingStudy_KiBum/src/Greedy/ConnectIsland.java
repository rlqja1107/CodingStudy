package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;


public class ConnectIsland {
	public static int solution(int n,int [][]costs) {
		HashSet<Integer> island=new HashSet<Integer>();
		int cost=0;
		//비용 기준으로 오름차순으로 Sort
		Arrays.sort(costs,new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[2]>o2[2])return 1;
				else if(o1[2]<o2[2])return -1;
				else return 0;
			}
		});
		//섬의 번호만 들어가있는 Set생성
		for(int []temp:costs) {
			island.add(temp[0]);
			island.add(temp[1]);
		}
		HashMap<Integer,HashSet<Integer>> set=new HashMap<Integer,HashSet<Integer>>();
		//HashMap 생성과 자기자신을 HashSet에 포함시킴
		for(Integer i:island) {
			set.put(i, new HashSet<Integer>());
			set.get(i).add(i);
		}
		for(int []temp:costs) {
			int start=temp[0];
			int end=temp[1];
			if(set.get(start).contains(end))
				continue;
			set.get(start).addAll(set.get(end));
			set.get(end).addAll(set.get(start));
			//cost를 더해줌
			cost+=temp[2];
			//
			for(Integer i:set.get(start)) {
				set.get(i).addAll(set.get(start));
			}
			if(set.get(start).equals(island))
				break;
			
		}
		return cost;
	}
	public static void main(String []args) {
		int c[][]= {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(solution(4,c));
		
		
	}
	
}
