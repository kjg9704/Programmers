import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {

	public static void main(String[] args) {
		int[] progresses = {95, 90, 99, 99, 80, 99};
		int[] speeds = {1, 1, 1, 1, 1, 1};
		for(int result : solution(progresses, speeds)) {
			System.out.print(result + " ");
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        int day = 1;
        for(int i : progresses) {
        	que1.add(i);
        }
        for(int i : speeds) {
        	que2.add(i);
        }
        while(!que1.isEmpty()) {
        	int distribute = 0;
        	if(que1.peek() + (que2.peek() * day) >= 100) {
        		while(!que1.isEmpty() && que1.peek() + (que2.peek() * day) >= 100) {
        			que1.poll();
        			que2.poll();
        			distribute++;
        		}
        	}
        	if(distribute > 0) {
        		arr.add(distribute);
        	}
        	day++;
        }
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) {
        	answer[i] = arr.get(i);
        }
        return answer;
    }

}
