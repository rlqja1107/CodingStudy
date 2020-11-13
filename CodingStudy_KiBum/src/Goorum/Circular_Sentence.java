package Goorum;

import java.io.*;
import java.util.*;
public class Circular_Sentence {
	public static void main(String[] args) 
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int total=Integer.parseInt(br.readLine());	
			ArrayList<Character> list=new ArrayList<Character>();
			for(int i=0;i<total;i++)
			{
				String word=br.readLine();
				if(word.length()<2&&word.length()>100000){
					System.out.println(2);
					continue;
				}
				int index=0;
				int count=1;
				boolean flag=true;
				list.clear();			
				for(int j=0;j<word.length();j++)
					list.add(word.charAt(j));
				while(index<list.size()-1-index)
				{
					Character forward=list.get(index);
					Character backward=list.get(list.size()-1-index);
					if(forward.equals(backward))				
						index++;	
					else
					{
						if(count==0)
						{
							System.out.println(2);
							flag=false;
							break;
						}
						if(forward.equals(list.get(list.size()-2-index)))
						{
							list.remove(list.size()-1-index);
							count--;
						}
						else if(backward.equals(list.get(index+1)))
						{
							list.remove(index);
							count--;
						}
						else{
							System.out.println(2);
							flag=false;
							break;
						}
					}
				}
				if(flag&&count==0){
					System.out.println(1);
				}
				else if(flag&&count==1){
					System.out.println(0);
				}
			}
		}
		catch(Exception e){
		}
	}
}
