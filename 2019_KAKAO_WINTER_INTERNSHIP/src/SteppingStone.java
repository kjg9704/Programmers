public class SteppingStone {

	public static void main(String[] args) {
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(solution(stones, k));
	}
	public static int solution(int[] stones, int k) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i : stones) {
			max = Math.max(max, i);
            min = Math.min(min, i);
		}
		if(min == max) {
			answer = min;
			return answer;
		}
		while(min <= max) {
			int mid = (min + max) / 2;
			if(check(stones, mid, k)) {
				answer = mid;
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}
		return answer;
	}
	static boolean check(int[] stones, int mid, int k) {
		int minNum = 0;
		for(int i = 0; i < stones.length; i++) {
			if(stones[i] - mid < 0) {
				minNum++;
			}
			else {
				minNum = 0;
			}
			if(minNum >= k) {
				return false;
			}
		}
		return true;
	}
}
