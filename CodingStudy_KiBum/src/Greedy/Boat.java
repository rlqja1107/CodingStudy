package Greedy;

import java.util.Arrays;

public class Boat {
	public static int solution(int[] people, int limit) {
		Arrays.sort(people);
		int index=0;
		int count=0;
		int temp=0;
		int num=100000;
		for(int i=1;i<people.length;i++) {
			if(people[0]+people[i]>limit) {
				people[i]=num;
				count++;
				temp=1;
			}
			else if(temp==0){
				index++;
			}
		}
		people=Arrays.copyOf(people, index+1);
		index=0;
		int index1=1,index2=people.length-1;
		int sum1=people[index2],sum2=people[0];
		int flag=0;
		while(index<people.length) {
		while(index<people.length) {
			if(sum1+people[index]<=limit) {
				sum1+=people[index];
				index++;
				flag=1;
			}
			else {
				if(flag==1) {
					index2--;
				}
				count++;
				break;
			}
			sum1=people[index2];
			
		}
		
		}

	


	return count;
}
public static void main(String []args) {
	int people[]= {20,50,50,80};
	int limit=100;
	System.out.println(solution(people,limit));
}
}
