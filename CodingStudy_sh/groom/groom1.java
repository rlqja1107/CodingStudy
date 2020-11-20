package groom;

import java.util.Scanner;

public class groom1 {

	static int canPalindrome(String s, int p, int q) { // 유사회문
		while (p <= q) {
			if (s.charAt(p) == s.charAt(q)) {
				p += 1;
				q -= 1;
			} else
				return 0;
		}
		return 1;
	}

	static int Palindrome(String s) {
		int p = 0;
		int q = s.length() - 1;
		int canPr, canPl;
		while (p < q) {
			if (s.charAt(p) != s.charAt(q)) { // 회문이아닌경우 ex)abab
				// 유사회문인지검사->맞으면 return 1
				canPr = canPalindrome(s, p + 1, q);
				canPl = canPalindrome(s, p, q - 1);
				// 둘다아님-> return 2
				if (canPr == 1 || canPl == 1)
					return 1;
				else
					return 2; // 회문,유사회문아님
			}

			p += 1;
			q -= 1;
		}
		return 0; // 회문임
	}

	public static void main(String[] args) throws Exception {
		int num;
		String[] s = new String[30];

		Scanner sc = new Scanner(System.in);
		num = sc.nextInt(); // 문자열 개수를 입력받음

		for (int i = 0; i < num; i++) {
			s[i] = sc.next();
		}

		int[] st = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.println(Palindrome(s[i]));
		}

	}
}
