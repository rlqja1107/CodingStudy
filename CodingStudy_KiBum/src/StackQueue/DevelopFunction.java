package StackQueue;
import java.util.*;
public class DevelopFunction {
	public int[] solution(int[] progresses, int[] speeds) {
	       ArrayList<Integer> answer_sample=new ArrayList<Integer>();
			ArrayList<Integer> progress=new ArrayList<Integer>();
			ArrayList<Integer> speed=new ArrayList<Integer>();
			
			for(int p=0;p<progresses.length;p++) {
				progress.add(progresses[p]);
	            speed.add(speeds[p]);
			}
			int publish_num=0;
			
			while(true) {
				for(int i=0;i<progress.size();i++) {
					progress.set(i,progress.get(i)+speed.get(i));
					if(progress.get(i)>=100) {
						progress.set(i,-1);
	                    speed.set(i,0);
					}	
				}
				for(int j=0; j<progress.size();j++) {
					if(progress.get(j)!=-1) {
						break;
					}
					else {
						
						publish_num++;
						// progress.remove(j);
						// speed.remove(j);
					}
		
				}
	             for(int k=0;k<publish_num;k++){
	                 progress.remove(k);
	                 speed.remove(k);
	             }
	            if(publish_num!=0){
				answer_sample.add(publish_num);}
					publish_num=0;
					if(progress.size()==0){
						break;}
					
			}
			int  []answer=new int[answer_sample.size()];
			

			for(int j=0;j<answer.length;j++) {
				answer[j]=answer_sample.get(j);
			}
			return answer;

	    }
}
