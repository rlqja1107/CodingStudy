package BaekJoon;
import java.util.*;

public class GoTrip {
	public static void plus(ArrayList<Set<Integer>> set,Set<Integer> check, int cur,int next){
	    check.add(next);
	    set.get(next).addAll(set.get(cur));
	    for(Integer data:set.get(next)){
	        if(!check.contains(data)&&data!=next){
	            plus(set,check,next,data);
	        }
	    }
	}
	public static void main(String []args){
	    Scanner scan=new Scanner(System.in);
	    int num_country=scan.nextInt();
	    int num_plan=scan.nextInt();
	    ArrayList<Set<Integer>> list=new ArrayList<Set<Integer>>();
	    Set<Integer> check=new HashSet<Integer>();
	    list.add(new HashSet<Integer>());
	    for(int i=0;i<num_country;i++){
	        list.add(new HashSet<Integer>()); 
	    }
	    for(int i=1;i<=num_country;i++){
	        for(int j=1;j<=num_country;j++){
	        	if(scan.nextInt()!=0) {
	        		 list.get(i).add(j);
                }
	        }
	        list.get(i).add(i);
	        check.add(i);
	            for(Integer data:list.get(i)){
	                  plus(list,check,i,data);            
	    }
	        check.clear();
	    }
	   
	    int plan[]=new int[num_plan+1];
	    for(int i=1;i<=num_plan;i++){
	        plan[i]=scan.nextInt();
	    }
        if(num_plan==1){
            System.out.println("YES");
            return;
        }
	    for(int i=1;i<=num_plan;i++){
	        if(i!=num_plan&&!list.get(plan[i]).contains(plan[i+1])){
	            System.out.println("NO");
	            return;
	        }
	       
	    }
	    System.out.println("YES");
}
}