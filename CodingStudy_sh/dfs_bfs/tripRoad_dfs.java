package dfs_bfs;

import java.util.*;

public class tripRoad_dfs {
	static String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },{ "ATL", "SFO" } };
	static List<String> li = new ArrayList<>();
	static List<String> sortList = new ArrayList<>();
	static String tripRoad = "";
	static int visited[] ;

	static void dfs(int[]visited,String[][] tickets, String end, int x, int cnt) {
		
		visited[x] = 1;
		
		tripRoad += end + ",";
		
		if (cnt == tickets.length) {
			li.add(tripRoad);
			return;
		}
		
		for (int i = 0; i < sortList.size(); i++) {
			String ticketTerm = sortList.get(i);
			String s = ticketTerm.substring(0, 3);
			String e = ticketTerm.substring(4, 7);

			if (end.equals(s) && visited[i] == 0) {
				dfs(visited,tickets, e, i, cnt + 1);
				visited[i] = 0;
				tripRoad = tripRoad.substring(0, tripRoad.length() - 4);

			}
		}
	}

	public static String[] solution(String[][] tickets) {
		
		visited= new int[tickets.length];
		
		for (int i = 0; i < tickets.length; i++) {
			String s = tickets[i][0];
			String e = tickets[i][1];
			sortList.add(s + "," + e + ",");
			Collections.sort(sortList);
			
		}
		
		for (int i = 0; i < sortList.size(); i++) {
			String ticketTerm = sortList.get(i);
			String s = ticketTerm.substring(0, 3);
			String e = ticketTerm.substring(4, 7);
			
			if (s.equals("ICN")) {
				tripRoad = s + ",";
				dfs(visited,tickets, e, i, 1);
				visited[i] = 0;
				
			}

		}
		
		String []answer=li.get(0).split(",");
		return answer;
	}

	public static void main(String[] args) {
		String[] answer = solution(tickets);
		for(int i=0;i<answer.length;i++) {
			System.out.print("\""+answer[i]+"\"");
			if(i==answer.length-1)continue;
			System.out.print(",");
		}

	}

}
