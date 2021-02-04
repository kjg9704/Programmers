import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MenuRenewal {

	static HashMap<String, Integer> map;
	public static void main(String[] args) {
	//	String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
	//	String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,5};
		solution(orders, course);
	}
	
	public static String[] solution(String[] orders, int[] course) {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        map = new HashMap<String, Integer>();
        for(String str: orders) {
        	for(int i = 0; i < str.length(); i++) {
        		if(!list.contains(str.charAt(i)+ "")) {
        			list.add(str.charAt(i) + "");
        		}
        	}
        }
        boolean[] visited = new boolean[list.size()];
        for(int i = 0; i < course.length; i++) {
        	combi(orders, list, visited, 0, course[i]);
        	visited = new boolean[list.size()];
        }
        for(int index : course) {
        	int max = 0;
        	for(String str : map.keySet()) {
        		if(str.length() == index) {
        			int num = map.get(str);
        			if(max < num && num >= 2) {
        				max = num;
                	}
        		}
            }
        	for(String str : map.keySet()) {
        		if(str.length() == index) {
        			if(map.get(str) == max) {
        				result.add(str);
        			}
        		}
        	}
        }
        Collections.sort(result);
        String[] answer = new String[result.size()];
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = result.get(i);
        }
        for(String str : answer) {
        	System.out.println(str);
        }
        return answer;
    }

	static void combi(String[] orders, ArrayList<String> list, boolean[] visited, int depth, int r) {
		if(r == 0) {
			String temp = "";
			for(int i = 0; i < list.size(); i++) {
				if(visited[i] == true) {
					temp += list.get(i);
				}
			}
			for(int i = 0; i < orders.length; i++) {
				boolean check = true;
				for(int j = 0; j < temp.length(); j++) {
					if(!orders[i].contains(temp.charAt(j) + "")) {
						check = false;
					}
				}
				if(check) {
					if(!map.containsKey(temp)) {
						map.put(temp, 1);
					}
					else {
						map.replace(temp, map.get(temp) + 1);
					}
				}
			}
			return;
		}
        if(depth == list.size()) {
            return;
        } else {
            visited[depth] = true;
            combi(orders, list, visited, depth + 1, r - 1);
 
            visited[depth] = false;
            combi(orders, list, visited, depth + 1, r);
        }
    }
}
