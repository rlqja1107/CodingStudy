package CodingStudy_sh.dfs_bfs;

public class word_conversion {
	static String[]words= new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
	static int visited[];
	static int answer;
	static int min;
	
	public static int min(int a, int b) {
		return a<b?a:b;
	}
	
	public static void dfs(int[]visited,String begin, String target, String[]words,int cnt) {
		min=words.length;
        
		if(begin.equals(target)) {
			answer=min(min,cnt);
			return;
		}
		
		for(int i=0;i<words.length;i++) {
			if(visited[i]==0) 
				if(do_convert(begin,words[i])) {
					visited[i]=1;
					dfs(visited,words[i],target,words,cnt+1);
					visited[i]=0;
			}
		}
		
	}
	
	private static boolean do_convert(String begin, String word) {
		
		int diff=0;
		
		for(int i=0;i<word.length();i++) {
			if(begin.charAt(i)!=word.charAt(i)) diff++;
		}
		
		if(diff==1) return true;
		return false;
	
	}
	
	public static int solution(String begin, String target, String[]words) {
		visited=new int[words.length];
		for(String word:words) {
			if(word.equals(target)) 
				dfs(visited,begin,target,words,0);
			else answer=0;
		} 
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		System.out.println(solution("hit","cog",words));

	}

}
