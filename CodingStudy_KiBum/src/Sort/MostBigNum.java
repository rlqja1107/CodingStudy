package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MostBigNum {

	public static String MakeThreeNum(String str) {
		if(str.equals("0"))
			return "0";
		String last_num=Integer.toString(str.length());
		String most_big=Integer.toString(where_big(str));
		System.out.println(most_big);
		if(str.length()==1) 
			return str+most_big+most_big+most_big+last_num;
		else if(str.length()==2)
			return str+most_big+most_big+last_num;
		else if(str.length()==3)
			return str+most_big+last_num;
		else 
			return str+last_num;
	}

	public static int where_big(String str) {
		int temp=0;
		for(int i=0;i<str.length();i++) {
			if(temp<Integer.parseInt(str.substring(i, i+1))) {
				temp=Integer.parseInt(str.substring(i, i+1));
			}
		}
		return temp;
	}

	public static String solution(int []numbers) {
		int num;
		int temp[]=new int[numbers.length];
		String str="";
		for(int i=0;i<numbers.length;i++) {
			str=MakeThreeNum(Integer.toString(numbers[i]));

			temp[i]=Integer.parseInt(str);
		}
		Arrays.sort(temp);
		str="";
		for(int j:temp)
			System.out.println(j);

		for(int j=temp.length-1;j>=0;j--) {
			if(temp[j]==0)
				str+="0";
			else {
				//catch last index of number
				num=Integer.parseInt((Integer.toString(temp[j]).substring(4)));
				str+=Integer.toString(temp[j]).substring(0,num);}
		}
		if(str.charAt(0)=='0')
			return "0";

		return str;
	}
	public static void main(String []args) {
		int a[]= {12,1213};
		System.out.println(solution(a));

	}

}
