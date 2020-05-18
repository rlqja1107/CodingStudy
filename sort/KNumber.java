package sort;

import java.util.*;

public class KNumber {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = new int[commands.length];
		int[] array2 = {};

		for (int i = 0; i < commands.length; i++) {
			array2 = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);			
			Arrays.sort(array2);
			answer[i] = array2[commands[i][2]-1];
		}

		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}