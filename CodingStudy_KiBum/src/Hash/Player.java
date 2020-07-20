package Hash;

import java.util.*;


public class Player {
	public String solution(String[] participant,String []completion) {
		if(participant.length>100000||participant.length==0)return "";
		 Arrays.sort(participant);
		 Arrays.sort(completion);
			for(int i=0;i<participant.length;i++) {
				if(i==participant.length-1||!participant[i].equals(completion[i])) {
					return participant[i];
			}
				
           }   
       return "";			
	}
}
