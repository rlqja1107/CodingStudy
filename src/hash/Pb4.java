package hash;
import java.util.*;

class Music implements Comparable<Music>{
	String genre;
	int play;
	
	public Music(String genre, int play) {
		this.genre = genre;
		this.play = play;
	}

	@Override
	//총 재생 횟수가 많은 순으로 우선순위 큐에 저장
	public int compareTo(Music target) {
		// TODO Auto-generated method stub
		return this.play < target.play ? 1 : -1;
	}
}

class Solution4 {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        //장르와 총 재생 횟수를 저장할 hash map
        HashMap<String,Integer> map1 = new HashMap<>();
        //장르와 대표되는 두 노래의 인덱스를 저장할 hash map
        HashMap<String,Object> map2 = new HashMap<>();
        //총 재생 횟수가 많은 순으로 저장할 우선순위 큐
        PriorityQueue<Music> q = new PriorityQueue<>();
        //대표되는 노래가 1곡 일수도 있고 2곡 일수도 있으므로 사이즈를 저장할 변수
        int size=0;
        
        for(int i=0;i<genres.length;i++){
        	//장르가 저장되어 있으면
            if(map1.containsKey(genres[i])){
            	//대표되는 인덱스를 저장한 배열을 가져옴
                int[] arr = (int[])map2.get(genres[i]); 
                //총 재생 횟수를 증가
                map1.replace(genres[i],map1.get(genres[i])+plays[i]);
                //대표되느 인덱스를 저장한 배열의 두 번째 값이 -1이면 대표되는 노래가 1개임
                if(arr[1]== -1){
                	//만약 먼저 저장된 노래의 재생 횟수가 현재 인덱스 재생 횟수 보다 많다면 배열의 두 번째에 인덱스 저장
                    if(plays[arr[0]]>plays[i]) arr[1]=i;
                    else{
                    	//먼저 저장된 노래의 재생 횟수가 현재 인덱스의 재생 횟수 보다 작다면 배열의 첫 번째에 현재 인덱스를 저장하고
                    	//먼저 저장된 인덱스 값을 뒤로 미룸
                        arr[1] = arr[0];
                        arr[0] = i;
                    }
                    //최대 2곡까지는 가능하므로 앨범 수록곡 사이즈 증가
                    size++;
                }
                //이미 대표되는 곡이 2개가 있다면
                else{
                	//첫 번째 저장된 곡 보다 현재 인덱스의 재생 횟수가 많다면
                    if(plays[arr[0]]< plays[i]){
                    	//현재 인덱스를 배열의 첫 번째에 저장하고 먼저 저장된 인덱스를 뒤로 미룸
                        arr[1] = arr[0];
                        arr[0] = i;
                    }
                    //첫 번째 저장된 곡 보다는 재생 횟수가 작지만 두 번째 저장된 곡 보다는 재생 횟수가 크다면 두 번째 배열 값을 현재 인덱스로 바꿈
                    else if(plays[arr[1]]< plays[i]) arr[1]=i;
                    //두 곡 보다 재생 횟수가 작을 경우 현재 인덱스를 저장하지 않음
                }
                //변경된 배열로 대체해줌
                map2.replace(genres[i],arr);
            }
            //장르가 저장되어 있지 않다면
            else {
            	//현재 인덱스와 -1을 저장한 크기가 2인 배열
                int[] arr = {i,-1};
                //장르와 총 재생 횟수를 hash map에 추가
                map1.put(genres[i],plays[i]);
                //장르와 현재 인덱스를 저장한 배열을 hash map에 추가
                map2.put(genres[i],arr);
                //앨범 수록곡의 사이즈 증가
                size++;
            }
        }
        
        //총 재생 횟수가 많은 순으로 우선 순위 큐에 저장
        for(String s: map1.keySet()) {
        	q.add(new Music(s,map1.get(s)));
        }
        
        //계산된 크기 만큼 배열 생성
        answer = new int[size];
        //반환할 배열의 인덱스
        int i=0;
        while(!q.isEmpty()) {
        	//우선순위 큐에서 가장 앞에 있는 장르의 hash에 저장된 인덱스 배열을 가져옴
        	int[] arr = (int[])map2.get(q.poll().genre);
        	//곡 하나는 무조건 존재 하므로 첫 번째 곡 인덱스를 저장
        	answer[i++]=arr[0];
        	//두 번째 곡이 존재 할 경우 두 번째 곡의 인덱스를 저장
        	if(arr[1]!=-1) answer[i++]=arr[1];
        }

 
        return answer;
    }
}

public class Pb4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//결과: [4, 1, 3, 0]
		
		//입력
		//노래의 장르
		String[] genres= {"classic", "pop", "classic", "classic", "pop"};	
		//노래의 재생 횟수
		int[] plays = {500, 600, 150, 800, 2500};
		
		Solution4 s = new Solution4();
		int[] answer =s.solution(genres, plays);
		for(int a:answer) {
			System.out.println(a);
		}
		
	}

}
