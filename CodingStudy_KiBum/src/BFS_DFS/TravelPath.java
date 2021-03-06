package BFS_DFS;
import java.util.*;
public class TravelPath {
	static int count=0;
    static String []answer;
	public static void dfs_find(String [][]tickets,String start,int []visit){
        String destination="ZZZ";
        int index=0;
        for(int i=0;i<tickets.length;i++){
            if(start.equals(tickets[i][0])&&visit[i]==0){
                if(destination.compareTo(tickets[i][1])>=0){
                    destination=tickets[i][1];
                    index=i;
                }
            }
        }
        System.out.println(destination);
        visit[index]=1;
        answer[count]=start;
        count++;
        
        if(count==tickets.length){
        answer[count]=destination;
            return;
        }
        else dfs_find(tickets,destination,visit);
        
        
    }
	  public static String[] solution(String[][] tickets) {
	        int []visit=new int[tickets.length];
	        answer=new String[tickets.length+1];
	        
	        dfs_find(tickets,"ICN",visit);
	        return answer;
	    }
}
