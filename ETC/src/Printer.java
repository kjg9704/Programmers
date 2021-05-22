import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> Pque = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> que = new LinkedList<>();
        Queue<Integer> indexQue = new LinkedList<>();
        for(int i = 0; i < priorities.length; i++) {
        	int num = priorities[i];
        	que.add(num);
        	Pque.add(num);
        	indexQue.add(i);
        }
        while(!que.isEmpty()) {
        	if(Pque.peek() > que.peek()) {
        		que.add(que.poll());
        		indexQue.add(indexQue.poll());
        	}else {
        		que.poll();
        		Pque.poll();
        		if(indexQue.poll() == location) {
        			break;
        		}
        		answer++;
        	}
        }
        return answer;
    }

}
