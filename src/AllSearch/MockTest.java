package AllSearch;

import java.util.Arrays;
import java.util.Comparator;

public class MockTest {
	public static int[] solution(int []answers){
		class compar implements Comparator<Integer[]>{

			@Override
			public int compare(Integer[] o1, Integer[] o2){
				if(o1[1]<o2[1])return 1;
				else if(o1[1]>o2[1])return -1;
				else return 0;			
			}
			
		}
		int []first= {1,2,3,4,5};
		int answer1=0,answer2=0,answer3=0;
		int []second= {2,1,2,3,2,4,2,5};
		int []third= {3,3,1,1,2,2,4,4,5,5};
		for(int i=0;i<answers.length;i++) {
			if(first[i%first.length]==answers[i])
				answer1++;
			if(second[i%second.length]==answers[i])
				answer2++;
			if(third[i%third.length]==answers[i])
				answer3++;
		}
		
		Integer answer[][]= {{1,answer1},{2,answer2},{3,answer3}};
		
		Arrays.sort(answer,new compar());
			
			
			int number=1;
		if(answer[0][1]==answer[1][1]) 
			number++;
		
		if(answer[0][1]==answer[2][1])
			number++;
		
		int a[]=new int[number];
		for(int i=0;i<number;i++) {
			a[i]=answer[i][0];
		}
		Arrays.sort(a);
		return a;
	}

	public static void main(String []args) {
		int answer[]= {3,3,1,1,2};
		
		for(int a:solution(answer))
			System.out.println(a);
	}
}
