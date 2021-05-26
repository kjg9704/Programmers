public class DPN {

	static int result = -1;
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}
	
	public static int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return result;
    }
	
	static void dfs(int N, int number, int depth, int now) {
		if(depth > 8) return;
		if(number == now && (result == -1 || result > depth)) {
			result = depth;
			return;
		}
		int temp = 0;
//		System.out.println(now + "  " + depth);
		for(int i = 0; i < 8; i++) {
			temp = temp * 10 + N;
			dfs(N, number, depth + 1 + i, now + temp);
			dfs(N, number, depth + 1 + i, now - temp);
			dfs(N, number, depth + 1 + i, now * temp);
			dfs(N, number, depth + 1 + i, now / temp);
		}
	}

}