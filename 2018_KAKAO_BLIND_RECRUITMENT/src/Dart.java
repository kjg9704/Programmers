import java.util.Stack;
import java.util.regex.Pattern;

public class Dart {

	public static void main(String[] args) {
		String [] dartResult = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
		for(String i : dartResult) {
			solution(i);
		}
	}
	
	public static int solution(String dartResult) {
		Stack<Integer> stack = new Stack<Integer>();
        int answer = 0;
        int N = dartResult.length();
        String nowNum = "";
      
        for(int i = 0; i < N; i++) {
        	String now = dartResult.charAt(i) + "";
        	if(Pattern.matches("[^0-9]", now)) {
        		if(now.equals("*")) {
        			int calc = stack.pop();
        			calc = calc * 2;
        			if(!stack.isEmpty()) {
        				int prevCalc = stack.pop();
        				prevCalc = prevCalc * 2;
        				stack.push(prevCalc);
        			}
        			stack.push(calc);
        		}
        		else if(now.equals("#")) {
        			int calc = stack.pop();
        			calc = calc * -1;
        			stack.push(calc);
        		}
        		else {
        			int addNum = Integer.parseInt(nowNum);
        			switch(now) {
        			case "D":
        				addNum = (int) Math.pow(Integer.parseInt(nowNum), 2);
        				break;
        			case "T":
        				addNum = (int) Math.pow(Integer.parseInt(nowNum), 3);
        				break;
        			}
        			stack.push(addNum);
        			nowNum = "";
        		}
        	}
        	else {
        		nowNum += now;
        	}
        }
        while(!stack.isEmpty()) {
        	answer += stack.pop();
        }
        System.out.println(answer);
        return answer;
    }

}
