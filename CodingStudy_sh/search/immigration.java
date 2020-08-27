package search;

public class immigration {
	static int n = 6;
	static int[] times = { 7, 10 };

	public static long min(long a, long b) {
		return a < b ? a : b;
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;

		long left = 0;
		long right = (long) times[times.length - 1] * n;
		long mid = 0;

		while (right - left >= 0) {

			long imm = 0;

			mid = (left + right) / 2;
			for (int i = 0; i < times.length; i++) {
				imm += mid / times[i];
			}
			if (imm >= n) {
				answer = min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		System.out.println(solution(n, times));
	}

}
