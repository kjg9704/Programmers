import java.util.HashMap;
import java.util.Map.Entry;

public class Camouflage {

	public static void main(String[] args) {
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < clothes.length; i++) {
			if(map.containsKey(clothes[i][1])) {
				map.replace(clothes[i][1], map.get(clothes[i][1]) + 1);
			}else {
				map.put(clothes[i][1], 1);
			}
		}
		int result = 1;
		for(Entry<String, Integer> set : map.entrySet()) {
			result *= (set.getValue() + 1);
		}
		return --result; 
	}
}
