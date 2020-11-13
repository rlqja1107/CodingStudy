package Goorum;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Double_Scale {
	public static void calculate(Set<Integer> set,int array[],int index) {
		Set<Integer> temp=new HashSet<Integer>();
		temp.add(array[index]);
		for(Integer val:set) {
			temp.add(val+array[index]);
			temp.add(val-array[index]);
			temp.add(array[index]-val);
		}
		set.addAll(temp);
	}
	public static void main(String[] args){
		Scanner br = new Scanner(new InputStreamReader(System.in));
		try {
			int num=br.nextInt();
			Set<Integer> set=new HashSet<Integer>();
			int array[]=new int[num];
			int sum=0;
			for(int i=0;i<num;i++){
				int val=br.nextInt();
				sum+=val;
				array[i]=val;
			}
			Arrays.sort(array);
			set.add(array[0]);
			for(int i=1;i<num;i++){
				calculate(set,array,i);
			}
			int count=0;
			for(int i=1;i<=sum;i++) {
				if(!set.contains(i)) 
					count++;		
			}
			System.out.println(count);
		}
		catch(Exception e) {

		}

	}
}
