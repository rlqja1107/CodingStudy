package DynamicProgramming;

import java.util.ArrayList;

public class IntegerTriangle {
	static int maxLevel;
	static int sum_array[];
	static ArrayList<Integer> array=new ArrayList<Integer>();
	//right=0,left=1
	//curlevel은 층
	public static void compare(int curlevel,int index,int rightOrleft) {
			//오른쪽으로 들어온 경우
			if(rightOrleft==0) {
				if(sum_array[index]<=(sum_array[index-curlevel]+array.get(index)))
					sum_array[index]=sum_array[index-curlevel]+array.get(index);
				else return;
		}
			//왼쪽으로 들어온 경우
			else{
				if(sum_array[index]<=(sum_array[index-(curlevel-1)]+array.get(index)))
					sum_array[index]=sum_array[index-(curlevel-1)]+array.get(index);
				else return;
			}
		if(curlevel+1<=maxLevel) {
		//왼쪽으로
		compare(curlevel+1,index+curlevel,1);
		//오른쪽으로
		compare(curlevel+1,index+curlevel+1,0);
		}
		}
	public static int solution(int [][]triangle) {
		
		array.add(0);
		for(int i=0;i<triangle.length;i++) {
			for(int j=0;j<triangle[i].length;j++)
				array.add(triangle[i][j]);
		}
		maxLevel=triangle.length;
		sum_array=new int[array.size()+1];
		compare(1,1,0);
		int max=0;
		for(int i=(array.size()-maxLevel+1);i<=array.size();i++) {
			if(max<sum_array[i])
				max=sum_array[i];
		}
		return max;
		
	}
	public static void main(String[] args) {
		int tri[][]= {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
		System.out.println(solution(tri));
	}

}
