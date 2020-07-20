package DynamicProgramming;

public class Tile {
	static long previous_value;
	static int previous_index;
	static long []array;
	public static long Fibbo(int n) {
		if(n==1||n==2) {
			array[n-1]=1;
			return 1;
		}
		//array index에 값이 안들어가 있으면 넣어주고
		//들어가있으면 그 값을 바로 return
		if(array[n-1]!=0)return array[n-1];
		array[n-2]=Fibbo(n-1);
		array[n-3]=Fibbo(n-2);
		if(n==previous_index) {
			previous_value=array[n-2]+array[n-3];
			return previous_value;
		}
		return array[n-2]+array[n-3];
	}
	public static long solution(int N) {
		previous_index=N-1;
		array=new long[N];
		long current_value=Fibbo(N);
		if(N==1)previous_value=0;
		if(N==2)previous_value=1;
		if(N==3)previous_value=1;
		return 2*current_value+2*(previous_value+current_value);
	}
	public static void main(String[] args) {
		System.out.println(solution(4));
		System.out.println(previous_value);
	}

}
