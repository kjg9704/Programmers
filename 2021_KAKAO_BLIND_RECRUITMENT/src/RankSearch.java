import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RankSearch {

	static HashMap<String, ArrayList<Integer>> map = new HashMap<>();
	public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		for(int i : solution(info, query)) {
			System.out.print(i + ", ");
		}
	}
	
	public static int[] solution(String[] info, String[] query) {
		int volNum = info.length;
		int queryNum = query.length;
		for(int i = 0; i < volNum; i++) {
			String[] temp = info[i].split(" ");
			dfs("",temp, 0);
		}
        int[] answer = new int[queryNum];
        for(String key : map.keySet()) {
        	ArrayList<Integer> list = map.get(key);
        	Collections.sort(list);
        }
        for(int i = 0; i < queryNum; i++) {
        	query[i] = query[i].replaceAll("and ", "");
        	String[] temp = query[i].split(" ");
        	int score = Integer.parseInt(temp[4]);
        	String key = temp[0] + temp[1] + temp[2] + temp[3];
        	if(!map.containsKey(key)) {
        		answer[i] = 0;
        		continue;
        	}
        	ArrayList<Integer> list = map.get(key);
        	int first = 0;
    		int last = list.size() - 1;
    		int index = 0;
    		while (first <= last) {
    			index = (first + last) / 2;
    			if (score <= list.get(index)) {
    				last = index - 1;
    			}else {
    				first = index + 1;
    			}
    		}
    		answer[i] = list.size() - first;
        }
        return answer;
    }
	
	static void dfs(String key, String[] info, int depth) {
		if(depth == 4) {
			if(map.containsKey(key)) {
				map.get(key).add(Integer.parseInt(info[4]));
				return;
			}else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(info[4]));
				map.put(key, list);
				return;
			}
		}
		dfs(key + info[depth], info, depth + 1);
		dfs(key + "-", info, depth + 1);
	}

}