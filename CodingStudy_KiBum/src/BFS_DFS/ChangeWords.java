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
		//���� �ϳ��� �ٸ� word�� wordArray�� �ִ� for��
		ArrayList<String> wordArray=new ArrayList<String>();
		for(String word: words) {
			int count=0;
			//""�� ���� ���ڷ� ����Ͽ� pass
			if(word.equals(""))
				continue;
			for(int i=0;i<begin.length();i++) {
				if(word.charAt(i)==begin.charAt(i))continue;
				count++;		
			}
			//�ϳ��� �ٸ��긦 ����
			if(count==1)
				wordArray.add(word);
		}
		//��ǥ�ܾ �����ϸ� ���߰� Arraylist�� ���� ���� �ְ� �� �̻��� Ž�� ����
		if(wordArray.contains(target_word)) {
			answer_final.add(answer);
			return;
		}
		
		for(String i:wordArray) {
			//�ڱ� �ڽ��� �ܾ �迭�κ��� ����
			//�ٸ� node�� ���� Ž���� �ܾ� ������ ���� memory_word�� index���
			for(int j=0;j<words.length;j++) {
				if(words[j].equals(i)) {
					memory_word=words[j];
					index=j;
					words[j]="";
					break;
				}
			}
			//����Լ�
			count(i,words);
			//�ٸ� ��� ���� Ž���� ����
			words[index]=memory_word;
		}

	}
	public static int solution(String begin,String target,String[] words) {
		target_word=target;
		count(begin,words);
		//�ּ����� ��� ����
		Collections.sort(answer_final);
		return answer_final.get(0);
	}

	public static void main(String[] args) {			
		String a[]= {"hot","dot","dog","lot","log","cog"};
		System.out.println(solution("hit","cog",a));
	}

}