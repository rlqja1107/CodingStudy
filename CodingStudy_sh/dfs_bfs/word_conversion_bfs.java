package dfs_bfs;
import java.util.*;

public class word_conversion_bfs {

	static String[] words = {"hot","dot","dog","lot","log","cog"};
	static Queue<Word> q ;

	static int visited[] ;
	static int answer;
	static int cnt=0;
	
	public static class Word{
		String word;
		int cnt_level;
		
		public Word(String word, int cnt_level) {
			this.word=word;
			this.cnt_level=cnt_level;
		} 
		
	}

	public static int min(int a, int b) {
		return a < b ? a : b;
	}

	public static void bfs(String begin, String target, String[] words) {
		
		q = new LinkedList<>();
		visited = new int[words.length];
		int min=words.length;
		q.add(new Word(begin,cnt));
		
		while (!q.isEmpty()) {
			Word w= q.poll();
			
			if (w.word.equals(target)) { 
				answer = min(min,w.cnt_level);
				break;
			}
		
			for (int i = 0; i < words.length; i++) {
				if (visited[i]==0 && do_convert(w, words[i])) {
					visited[i]=1;
					q.add(new Word(words[i],w.cnt_level+1));
				}
			}
		}
	}

	private static boolean do_convert(Word w, String word) {

		int diff = 0;
		String w1=w.word;
		
		for (int i = 0; i < word.length(); i++) {
			if (w1.charAt(i) != word.charAt(i)) 
				diff++;
		}

		if (diff == 1)
			return true;

		return false;

	}

	public static int solution(String begin, String target, String[] words) {
		
		for (String word : words) {
			if (!word.equals(target)) {
				answer = 0; 
				break;
				}
		}
		
		bfs(begin, target, words);
		
		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution("hit", "cog", words));

	}

}

}
