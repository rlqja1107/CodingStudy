package Hash;
import java.util.*;

public class BestAlbun {
	public int [] solution(String []geners,int []plays) {
		ArrayList<Integer> order=new ArrayList<Integer>();
		//num vs plays
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
		//num vs (genre)
		HashMap<Integer,String> album=new HashMap<Integer,String>();
		//genre vs plays
		HashMap<String,Integer> hash2=new HashMap<String,Integer>();
		for(int i=0;i<geners.length;i++) {
			hash.put(i, plays[i]);
			album.put(i,geners[i]);
			if(!hash2.containsKey(geners[i])){
			hash2.put(geners[i], plays[i]);}
			else {
				hash2.replace(geners[i], hash2.get(geners[i])+plays[i]);
			}
		}
		//for문을 돌리면서 genre 순으로 세우고 해당 장르
	}
}
