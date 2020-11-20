package groom;

import java.util.Scanner;

public class groom1 {

	static int canPalindrome(String s, int p, int q) { // ����ȸ��
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
			if (s.charAt(p) != s.charAt(q)) { // ȸ���̾ƴѰ�� ex)abab
				// ����ȸ�������˻�->������ return 1
				canPr = canPalindrome(s, p + 1, q);
				canPl = canPalindrome(s, p, q - 1);
				// �Ѵپƴ�-> return 2
				if (canPr == 1 || canPl == 1)
					return 1;
				else
					return 2; // ȸ��,����ȸ���ƴ�
			}

			p += 1;
			q -= 1;
		}
		return 0; // ȸ����
	}

	public static void main(String[] args) throws Exception {
		int num;
		String[] s = new String[30];

		Scanner sc = new Scanner(System.in);
		num = sc.nextInt(); // ���ڿ� ������ �Է¹���

		for (int i = 0; i < num; i++) {
			s[i] = sc.next();
		}

		int[] st = new int[num];

		for (int i = 0; i < num; i++) {
			System.out.println(Palindrome(s[i]));
		}

	}
}
