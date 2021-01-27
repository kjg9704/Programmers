import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FormulaMaximization {
	static ArrayList<Long> results;
	static List<String> numbers;
	public static void main(String[] args) {
		String [] expression = {"100-200*300-500+20", "50*6-3*2"};
		for(String exp : expression) {
			solution(exp);
		}
	}
	public static long solution(String expression) {
        long answer = 0;
        ArrayList<String> operator = new ArrayList<String>();
        if(expression.contains("*")) {
        	operator.add("*");
        }
        if(expression.contains("+")) {
        	operator.add("+");
        }
        if(expression.contains("-")) {
        	operator.add("-");
        }
        numbers = new ArrayList<String>();
        int start = 0;
        for(int i = 0; i < expression.length(); i++) {
        	char index = expression.charAt(i);
        	if(index == '+' || index == '-' || index == '*'){
        		numbers.add(expression.substring(start, i));
        		numbers.add(index + "");
        		start = i + 1;
        	}
        	if(i == expression.length() - 1) {
        		numbers.add(expression.substring(start));
        	}
        }
        results = new ArrayList<Long>();
        permutation(operator, 0, operator.size(), operator.size());
        System.out.println(Collections.max(results));
        return answer;
    }
	
	static void permutation(ArrayList<String> arr, int depth, int n, int r) {
	    if (depth == r) {
	    	ArrayList<String> test = new ArrayList<String>();
	    	test.addAll(numbers); 	
	    	while(test.size() != 1) {
	    		for(String oper : arr) {
	    			for(int i = 0; i < test.size(); i++) {
	    				if(test.get(i).equals(oper)) {
	    					if(oper.equals("*")) {
	    						long calc = Long.parseLong(test.get(i - 1)) * Long.parseLong(test.get(i + 1));
	    						test.set(i - 1, calc+"");
	    						test.remove(i);
	    						test.remove(i);
	    						i = 0;
	    					}
	    					else if(oper.equals("-")) {
	    						long calc = Long.parseLong(test.get(i - 1)) - Long.parseLong(test.get(i + 1));
	    						test.set(i - 1, calc+"");
	    						test.remove(i);
	    						test.remove(i);
	    						i = 0;
	    					}
	    					else if(oper.equals("+")) {
	    						long calc = Long.parseLong(test.get(i - 1)) + Long.parseLong(test.get(i + 1));
	    						test.set(i - 1, calc+"");
	    						test.remove(i);
	    						test.remove(i);
	    						i = 0;
	    					}
	    				}
	    			}
	    		}
	    	}
	        results.add(Math.abs(Long.parseLong((test.get(0)))));
	        return;
	    }
	 
	    for (int i=depth; i<n; i++) {
	        swap(arr, depth, i);
	        permutation(arr, depth + 1, n, r);
	        swap(arr, depth, i);
	    }
	}
	 
	static void swap(ArrayList<String> arr, int depth, int i) {
	    String temp = arr.get(depth);
	    arr.set(depth, arr.get(i));
	    arr.set(i, temp);
	}
}
