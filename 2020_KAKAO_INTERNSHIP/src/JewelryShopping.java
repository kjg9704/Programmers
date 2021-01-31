import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class JewelryShopping {

	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
	//	String[] gems = {"AA", "AB", "AC", "AA", "AC"};
	//	String[] gems = {"XYZ", "XYZ", "XYZ"};
	//	String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
	//	String[] gems = {"DIA", "EM", "EM", "RUB", "DIA"};
		solution(gems);
	}
	
	public static int[] solution(String[] gems) {
		HashSet<String> jewelry = new HashSet<String>();
		HashMap<String, Integer> set = new HashMap<String, Integer>();
		int[] answer = {0,0};
		for(String str : gems) {
			jewelry.add(str);
		}
		int max = jewelry.size();
		int minIndex = 0;
		boolean isChanged = false;
		for(int i = 0; i < gems.length; i++) {
			int beforeIndex = 0;
			if(set.get(gems[i]) != null) {
				beforeIndex = set.get(gems[i]);
			}
			if(minIndex == beforeIndex) {
				isChanged = true;
			}
			else {
				isChanged = false;
			}
			set.put(gems[i], i + 1);
			if(set.size() == max) {
				if(isChanged) {
					minIndex = Collections.min(set.values());
					if(answer[0] == 0) {
						answer[0] = minIndex;
						answer[1] = i + 1;
					}
					else if(answer[1] - answer[0] > i + 1 - minIndex) {
						answer[0] = minIndex;
						answer[1] = i + 1;
					}
				}
			}
		}
		for(int i : answer) System.out.println(i);
		return answer;
	}
}
