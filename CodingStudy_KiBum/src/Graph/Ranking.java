package Graph;
import java.util.*;
public class Ranking {
	//set에 standard의 지는 목록들을 넣어주기
	public static void put_loose_ranking(HashMap<Integer,Set<Double>> map,int standard,Set<Double>set,int compare) {
		Set<Double>sub_set=map.get(standard);
		for(Double val:sub_set){
			double value=Math.round(val);
			if(val-value>0){
				set.add(val);
				if(compare<(int)value) {
					put_loose_ranking(map,(int)value,set,(int)value);
				}
			}

		}
	}
	//set에 standard의 이기는 목록 넣어주기
	public static void put_win_ranking(HashMap<Integer,Set<Double>> map,int standard,Set<Double>set,int compare) {
		Set<Double>sub_set=map.get(standard);
		for(Double val:sub_set) {
			double value=Math.round(val);
			if(val-value<0){
				set.add(val);
				if(compare<(int)value)
					put_win_ranking(map,(int)value,set,(int)value);

			}

		}}
	//이기면 원래의 node 값에 0.1을 더하여 진 노드의 값을 Set에 넣고,
	//지면 원래의 node 값에 0.1을 빼서 이긴 노드의 값을 Set에 넣어 진 노드인지 이긴 노드인지 구분
	public static int solution(int n, int results[][]) {
		HashMap<Integer,Set<Double>> graph=new HashMap<Integer,Set<Double>>();
		for(int i=1;i<=n;i++) {
			graph.put(i,new HashSet<Double>());
		}
		for(int []val:results) {
			graph.get(val[0]).add(val[1]+0.1);
			graph.get(val[1]).add(val[0]-0.1);
		}
		for(int i=1;i<=n;i++){
			Set<Double> list=graph.get(i);
			Set<Double> list2=new HashSet<Double>();
			for(double val:list){
				double value=Math.round(val);
				//0보다 크다는 것은 이 노드가 졌다는 것을 의미
				if(val-value>0) {
					put_loose_ranking(graph,(int)value,list2,i);
				}
				//0보다 작다는 것은 이 노드가 이겼다는 것을 의미
				else {
					put_win_ranking(graph,(int)value,list2,i);
				}
			}
			list.addAll(list2);
		}

		int answer=0;
		//전체 노드의 갯수와 비교한 정보가 Set에 들어있으면 answer++
		for(int i=1;i<=n;i++) {
			if(graph.get(i).size()>=n-1)
				answer++;
		
		}

		return answer;

	}
	public static void main(String[] args) {

		int n=5;
		int results[][]= {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5,results));
	}}
