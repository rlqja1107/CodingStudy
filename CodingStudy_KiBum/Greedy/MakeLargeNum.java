package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class MakeLargeNum {
	
	public static String make_string(int array[]) {
		String answer="";
		for(int i=0;i<array.length;i++) {
 			if(array[i]!=-1) {
 				answer+=array[i];
 			}
 		}
		return answer;
	}
	public static String solution(String number,int k) {
	
		int array[]=new int[number.length()];
 		for(int i=0;i<number.length();i++) {
 			array[i]=Integer.parseInt(number.substring(i,i+1));
		}
 	
 		int compare=100;
 		int temp;
 		int index=1;
 		int flag=0;
 		outer:
 		while(true) {
 		for(int i=0;i<array.length;i++) {
 			if(array[i]==-1) {
 				index++;
 				continue;
 			}
 			temp=compare;
 			compare=array[i];
 			
 			if(temp<array[i]) {
 				array[i-index]=-1;
 				k--;
 				if(k==0)
 					break outer;
 				flag=1;
 				break;
 			}
 			index=1;
 		}
 		if(flag==0) {
 			for(int i=0;i<k;i++) {
 				array[array.length-(i+1)]=-1;
 			}
 			return make_string(array);
 		}
 		index=1;
 		compare=100;
 		}
 		
		return make_string(array);
		
	}
	
	public static void main(String args[]) {
		String temp="9999";
		System.out.println(temp);
		System.out.println(solution(temp,2));
	}

}
