import java.util.ArrayList;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		String [] answer = solution(record);
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	public static String[] solution(String[] record) {
        int num = record.length;
        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0; i < num; i++) {
        	String[] temp = record[i].split(" ");
        	String query = temp[0];
        	String id = temp[1];
        	String nick = null;
        	if(!query.equals("Leave")){
        		nick = temp[2];
        		if(query.equals("Enter")) {
        			map.put(id, nick);
        			arr.add(id + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
            	}
        		else {
        			map.put(id, nick);
        		}
        	}
        	else {
        		arr.add(id + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
        	}
        }
        int size = arr.size();
        String[] answer = new String[size];
        for(int i = 0; i < size; i++) {
        	String[] temp = arr.get(i).split("´Ô");
        	String nickname = arr.get(i);
        	nickname = nickname.replace(temp[0], map.get(temp[0]));
        	answer[i] = nickname;
        }

        return answer;
    }

}
