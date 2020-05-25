package bf_search;

import java.util.*;

public class PrimeNumber {
	public static void main(String[] args) {
		String numbers = "178";
		int answer = 0;
		String[] num = new String[numbers.length()];
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<String> ans_arr = new ArrayList<>();
		
		for (int i = 0; i < numbers.length(); i++) {
			num[i] = Integer.toString(numbers.charAt(i) - '0');
//			System.out.print(num[i] + " ");
		}
		
		for (int i = 2; i < Math.pow(10, numbers.length()); i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			
			if (isPrime) {				
				al.add(i);
			}
		}
		
		String[] pnum = new String[al.size()];
		int size = 0;
		for (int a : al) {
			pnum[size++] = Integer.toString(a);
		}

		for (int i = 0; i < al.size(); i++) {
			int count = 0;
			for (int j = 0; j < pnum[i].length(); j++) {
				for (int k = 0; k < num.length; k++) {
					if (pnum[i].charAt(j) == num[k].charAt(0)) { 
						count++;
					}
				}
				if (count == pnum[i].length()) {
					ans_arr.add(pnum[i]);
					break;
				}
			}
		}	
		
		String[] ans = new String[ans_arr.size()];
		size = 0;
		for (String an : ans_arr) 
			ans[size++] = an;

		answer = ans.length;
		
		int count = 0;
		for (int i = 0; i < ans.length; i++) {
			String index = "";
			if (numbers.contains(ans[i]))
			if (ans[i].length() == 1 && Integer.parseInt(ans[0]) != 3 && Integer.parseInt(ans[0]) != 5 && Integer.parseInt(ans[0]) != 7) {
				answer--;
				count++;
				i++;
			}
			for (int j = 0; j < ans[i].length(); j++) {
				for (int k = 0; k < numbers.length(); k++) {
					if (ans[i].charAt(j) == numbers.charAt(k) && index == "") {
					index += k;
					break;
					}
					if (ans[i].charAt(j) == numbers.charAt(k) && ! index.contains(Integer.toString(k))) {
						index += k;
						break;
					}
					if (ans[i].charAt(j) == numbers.charAt(k) && index.contains(Integer.toString(k))) {
						answer--;
						count++;
						break;
					}
				}
				if (! numbers.contains(Character.toString(ans[i].charAt(j)))) {
					answer = 0;
					answer += count;
					break;
				}
			}
		}
		System.out.println(answer);
	}
}