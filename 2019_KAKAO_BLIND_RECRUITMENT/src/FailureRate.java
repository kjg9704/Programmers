import java.util.ArrayList;
import java.util.Collections;

public class FailureRate {

	public static void main(String[] args) {
		int N = 8;
		int [] stages = {1,2,3,4,5,6,7};
		solution(N, stages);
	}
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<Double> failure = new ArrayList<Double>();
        for(int i = 0; i < N; i++) {
        	int divide = 0;
        	int notClear = 0;
        	for(int j = 0; j < stages.length; j++) {
        		if(stages[j] >= i + 1) {
        			divide++;
        		}
        		if(stages[j] == i + 1 && stages[j] != N + 1) {
        			notClear++;
        		}
        	}
        	double rate = 0;
        	try {
        		if(divide == 0) {
        			rate = 0;
        		}
        		else {
        			rate = (double)notClear / (double) divide;
        		}
        	}
        	catch(Exception e) {
        		rate = 0;
        	}
        	failure.add(rate);
        }
        for(int i = 0 ; i < N; i++) {
        	double temp = Collections.max(failure);
        	for(int j = 0; j < N; j++) {
        		if(failure.get(j) == temp) {
        			answer[i] = j + 1;
        			failure.set(j, (double)-1);
        			break;
        		}
        	}
        }
        for(int i : answer) {
        	System.out.print(i + " ");
        }
        return answer;
    }

}
