import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;


public class MenuRenewal {
	static HashMap<String, Integer> map;
	static int MAX;

	public static void main(String[] args) {
		//	String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		//	String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		System.out.println(Arrays.toString(solution(orders, course)));
	}

	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> result = new ArrayList<String>();
		HashSet<String> set = new HashSet<>();
		
		for(String str: orders) {
			for(int i = 0; i < str.length(); i++) {
				set.add(str.charAt(i)+"");
			}
		}
		
		ArrayList<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		
		for(int i = 0; i < course.length; i++) {
			boolean[] visited = new boolean[list.size()];
			map = new HashMap<String, Integer>();
			MAX = Integer.MIN_VALUE;
			combi(orders, list, visited, 0, course[i]);
			
			for(String str : map.keySet()) {
				if(MAX >= 2 && map.get(str) == MAX) {
					result.add(str);
				}
			}
		}


		Collections.sort(result);
		String[] answer = new String[result.size()];
		for(int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}

	static void combi(String[] orders, ArrayList<String> list, boolean[] visited, int start, int r) {
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
						break;
					}
				}
				if(check) {
					map.put(temp, map.getOrDefault(temp, 0)+1);
					MAX = Math.max(MAX, map.get(temp));
				}
			}
			return;
		} else {
			for(int i = start; i < list.size(); i++) {
				visited[i] = true;
				combi(orders, list, visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}
}
