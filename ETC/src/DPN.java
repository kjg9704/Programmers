
public class DPN {

	static int[] dp = new int[32001];
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));
	}
	
	public static int solution(int N, int number) {
        int[] dp = new int[32001];
        dp[1] = 2;
        dp[N] = 1;
        if(N == 1) dp[1] = 1;
        if(N == number) return 1;
        
        
        if(dp[number] > 8) {
        	return -1;
        }
        return dp[number];
    }
	

}