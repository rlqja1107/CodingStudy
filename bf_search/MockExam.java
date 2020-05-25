package bf_search;

import java.util.*;

public class MockExam {
	public static void main(String[] args) {
		int[] answers = {1, 3, 2, 4, 2};		
 		int[] student1 = {1, 2, 3, 4, 5};
		int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int[] count = new int[3];
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i%5])
				count[0]++;
			if (answers[i] == student2[i%8])
				count[1]++;
			if (answers[i] == student3[i%10])
				count[2]++;
		}
		
		int max = Math.max(count[0], Math.max(count[1], count[2]));
		
		if (max == count[0])
			al.add(1);
		
		if (max == count[1])
			al.add(2);
		
		if (max == count[2])
			al.add(3);
	    
	    int[] answer = new int[al.size()];
	    int size = 0;
	    for (int a : al) {
	    	answer[size++] = a;
	    }
	    
	    for (int i = 0; i < answer.length; i++) {
	    	System.out.print(answer[i]);
	    }
	}		
}