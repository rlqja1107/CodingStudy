import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
			int a = commands[i][0];
			int b = commands[i][1];
			int[] newarray = new int[b - a + 1];
			
			int index = 0;
			for(int j=a-1; j<b; j++)
				newarray[index++] = array[j];
			
			Arrays.sort(newarray);
			
			answer[i] = newarray[commands[i][2]-1];
		}
        return answer;
    }
}