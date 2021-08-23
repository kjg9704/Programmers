import java.util.HashMap;

public class Week04 {

	public static void main(String[] args) {
		String[] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
		String[] languages = {"PYTHON", "C++", "SQL"};
		int[] preference = {7, 5, 5};
		System.out.println(solution(table, languages, preference));
	}

	public static String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < 5; i++) {
        	String[] temp = table[i].split(" ");
        	for(int j = 1; j < 6; j++) {
        		map.put(temp[0] + " " + temp[j], 6 - j);
        	}
        }
        int len = languages.length;
        int max = 0;
        for(int i = 0; i < 5; i++) {
        	String job = table[i].split(" ")[0];
        	int sum = 0;
        	for(int j = 0; j < len; j++) {
        		String key = job + " " + languages[j];
            	if(map.containsKey(key)) {
            		sum += map.get(key) * preference[j];
            	}
        	}
        	if(sum > max) {
        		answer = job;
        		max = sum;
        	}else if(sum == max) {
        		if(answer.compareTo(job) > 0) {
        			answer = job;
        			max = sum;
        		}
        	}
        }
        
        return answer;
    }
}
