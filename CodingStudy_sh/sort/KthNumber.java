package sort;

public class KthNumber {
	static int[] array = { 1, 5, 2, 6, 3, 7, 4 };
	static int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

	private static void sortFind(int[] a, int o, int[] answer, int order) {
		int min, temp;
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			min = 99;
			for (int j = i; j < a.length; j++) {
				if (min > a[j]) {
					min = a[j];
					index = j;
				}
			}
			temp = a[i];
			a[i] = a[index];
			a[index] = temp;

		}
		answer[order - 1] = a[o - 1];

	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int[] a;
		int cnt = 0;

		for (int i = 0; i < commands.length; i++) {
			cnt++;
			int k = 0;
			int s = commands[i][0]; // 2
			int e = commands[i][1]; // 5
			int o = commands[i][2]; // 3
			a = new int[e - s + 1];
			for (int j = s - 1; j < e; j++) {
				a[k++] = array[j];
				if (k == a.length)
					sortFind(a, o, answer, cnt);
			}

		}

		return answer;
	}

	public static void main(String[] args) {

		int[] result = solution(array, commands);
		for (int n : result)
			System.out.print(n + " ");

	}

}
