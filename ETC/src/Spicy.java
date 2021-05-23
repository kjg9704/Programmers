import java.util.PriorityQueue;

public class Spicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3};
		int K = 15;
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i : scoville) {
        	que.add(i);
        }
        while(que.size() >= 2 && que.peek() < K) {
        	int mix = que.poll() + (que.poll() * 2);
        	que.add(mix);
        	answer++;
        }
        if(que.peek() < K) {
        	return -1;
        }
        return answer;
    }

}
