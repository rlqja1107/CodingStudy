package AllSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindMinority {
	public static int ar[];

	public static int result[];
	public static int number=0;
	static Set<Integer> set=new HashSet<Integer>();
	
	public static int solution(String numbers) {
		
		int a[]=new int[numbers.length()];
		
		for(int i=0;i<a.length;i++) { 
			a[i]=Character.getNumericValue(numbers.charAt(i));
		}
		ar=a;
		
		result=new int[1];

		int num=1;
		while(num<=numbers.length()) {
			perm(0,num);

			num++;
			result=new int[num];
			
		}
		int count=0;
		for(int st:set) {
			
			if(find(st))
					count++;
		}
		return count;
			
	}
	public static void perm(int depth,int num) {
		if(num==depth) {
			set.add(Integer.parseInt(Arrays.toString(result).replaceAll("[^0-9]", "")));
			return;
		}
		for(int k=depth;k<ar.length;k++) {
			swap(depth,k);
			result[depth]=ar[depth];
			perm(depth+1,num);
			swap(depth,k);
		}
		
	}
	public static boolean find(int num) {
		int div=2;
		if(num==0||num==1)
			return false;
		while(div<num) {
			if(num%div==0) {
				return false;
			}
			div++;
		}
		return true;
	}
	public static void swap(int i,int j) {
		int temp=ar[i];
		ar[i]=ar[j];
		ar[j]=temp;
		
	}
	public static void main(String args[]) {
		System.out.println(solution("17"));
		

	}
}
