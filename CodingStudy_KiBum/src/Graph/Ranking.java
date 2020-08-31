package Graph;
import java.util.*;
public class Ranking {
	//set�� standard�� ��ϵ��� �־��ֱ�
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
	//�̱�� int[1] �ڸ��� 1,���� int[1]�ڸ��� 0, int[0]���� ��(����)
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
				//����Ǿ��ִ� ������� ������� �־��ֱ�,
				if(val-value>0) {
					put_loose_ranking(graph,(int)value,list2,i);
				}
				else {
					put_win_ranking(graph,(int)value,list2,i);
				}
			}
			list.addAll(list2);
		}

		int answer=0;
		for(int i=1;i<=n;i++) {
			if(graph.get(i).size()>=n-1)
				answer++;
			System.out.println(i+","+Arrays.deepToString(graph.get(i).toArray()));
		}

		return answer;

	}
	public static void main(String[] args) {

		int n=5;
		int results[][]= {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5,results));
	}}