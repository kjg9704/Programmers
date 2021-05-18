import java.util.HashMap;
import java.util.Set;

public class Marathon {

	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();
		for(int i = 0; i < participant.length; i++) {
			if(map.containsKey(participant[i])) {
				map.put(participant[i], map.get(participant[i])+ 1);
			}else {
				map.put(participant[i], 1);
			}
			
		}
		for(int i = 0; i < completion.length; i++) {
			if(map.get(completion[i]) == 1) {
				map.remove(completion[i]);
			}else {
				map.replace(completion[i], map.get(completion[i]) - 1);
			}
		}
		Set<String> set = map.keySet();
		Object[] arr = set.toArray();
		return arr[0].toString();
	}

}
