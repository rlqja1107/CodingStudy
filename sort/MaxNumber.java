package sort;

import java.util.*;

class Al {
	int index;
	String str;
	
	Al(String str, int index) {
		this.index = index;
		this.str = str;
	}
}

public class MaxNumber {
	public static void main(String[] args) {
	    int[] numbers = {2, 221};
	    String answer = "";
	    int index;

	    ArrayList<Al> al = new ArrayList<>();

	    for(int i = 0; i < numbers.length; i++) {
	    	index = i;
	    	Al arl = new Al(new String(new char[3]).replace("\0", String.valueOf(numbers[i])), index);
	    	al.add(arl);
	    }	
	    
	    al.sort(new Comparator<Al>() {
	         public int compare(Al o1, Al o2) {
	            if(o1.str.compareTo(o2.str)>0)
	               return -1;
	            else if(o1.str.compareTo(o2.str)==0)
	               return 0;
	            else
	               return 1;
	         }
	      });
        
	    for (int i = 0; i < al.size(); i++) {
	        index = al.get(i).index;
            answer += Integer.toString(numbers[index]);
        }
       	    
	    for (int i = 0; i < al.size(); i++) {
	    	int in = al.get(i).str.charAt(0) - '0';
	        if (i == 0 && in == 0) {
	        	answer = "0";
	        	break;
	        }
	    }
	   
        System.out.println(answer);
	}
}