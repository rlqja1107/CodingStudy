package Greedy;

import java.util.*;

public class lifeBoat {

	static int[] people = { 10,20,30,40,50,60,70,80,90};
	static int limit = 100;

	public static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);

		int j = people.length - 1;

		for (int i = 0;;) {
			if (people[i] + people[j] < limit) {
				answer++;
				i++;
				j--;

			} else if (people[i] + people[j] > limit) {
				answer++;
				j--;
			} else {
				answer++;
				i++;
				j--;
			}

			if (i > j) {

				break;
			}

		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(people, limit));

	}

}
