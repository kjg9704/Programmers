public class Immigration {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {4, 10};
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		long length = times.length;
		for(int i : times) {
			min = Math.min(min, i);
			max = Math.max(max, i);
		}
		min = (long)min * (long)n / length;
		max = (long)max * (long)n / length;
		if(min == max) {
			long count = 0;
			long mid = (min + max) / 2;	
			count = count(times, mid, n);
			while(count <= n) {
				mid++;
				count = count(times, mid, n);
			}
			answer = mid;
		}
		while(min <= max) {
			long mid = (min + max) / 2;	
			long cnt = count(times, mid, n);
			if(cnt >= n) {
				max = mid - 1;
				answer = Math.min(answer, mid);
			}
			else {
				min = mid + 1;
			}
		}
		return answer;
	}
	static long count(int[] times, long mid, int n) {
		long count = 0;
		for(int i : times) {
			count += mid / i;
		}
		return count;
	}
}
