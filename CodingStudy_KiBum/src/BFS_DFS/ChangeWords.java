package BFS_DFS;

import java.util.ArrayList;
import java.util.Collections;

public class ChangeWords {
	static int answer=0;
	static String target_word;
	static ArrayList<Integer> answer_final=new ArrayList<Integer>();
	public static void count(String begin,String []words) {
		String memory_word="";
		int index=0;
		answer++;
		//문자 하나만 다른 word를 wordArray에 넣는 for문
		ArrayList<String> wordArray=new ArrayList<String>();
		for(String word: words) {
			int count=0;
			//""는 없는 문자로 취급하여 pass
			if(word.equals(""))
				continue;
			for(int i=0;i<begin.length();i++) {
				if(word.charAt(i)==begin.charAt(i))continue;
				count++;		
			}
			//하나만 다른얘를 넣음
			if(count==1)
				wordArray.add(word);
		}
		//목표단어가 존재하면 멈추고 Arraylist에 깊이 층을 넣고 더 이상의 탐색 중지
		if(wordArray.contains(target_word)) {
			answer_final.add(answer);
			return;
		}
		
		for(String i:wordArray) {
			//자기 자신의 단어를 배열로부터 삭제
			//다른 node의 깊이 탐색시 단어 복구를 위해 memory_word와 index사용
			for(int j=0;j<words.length;j++) {
				if(words[j].equals(i)) {
					memory_word=words[j];
					index=j;
					words[j]="";
					break;
				}
			}
			//재귀함수
			count(i,words);
			//다른 노드 깊이 탐색시 복구
			words[index]=memory_word;
		}

	}
	public static int solution(String begin,String target,String[] words) {
		target_word=target;
		count(begin,words);
		//최소한의 방법 도출
		Collections.sort(answer_final);
		return answer_final.get(0);
	}

	public static void main(String[] args) {			
		String a[]= {"hot","dot","dog","lot","log","cog"};
		System.out.println(solution("hit","cog",a));
	}

}
