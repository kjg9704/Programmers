import java.util.*;

public class Personal_Information {

	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = {"A 6", "B 12", "C 3"};
		String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
		
//		String today = "2020.01.01";
//		String[] terms = {"Z 3", "D 5"};
//		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
		
		int[] result = solution(today, terms, privacies);
		
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		
	}
	
	public static int[] solution(String today, String[] terms, String[] privacies) {
		HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < terms.length; i++) {
        	String[] temp = terms[i].split(" ");
        	
        	char ch = temp[0].charAt(0);
        	int exp = Integer.parseInt(temp[1]);
        	
        	map.put(ch, exp);
        }
        
        for(int i = 0; i < privacies.length; i++) {
        	String[] temp = privacies[i].split(" ");
        	String date = temp[0];
        	char ch = temp[1].charAt(0);
        	
        	String ex_date = add_date(date, map.get(ch));
        	
        	if(!check(today, ex_date)) {
        		arr.add(i + 1);
        	}
        	
        }
        
        int[] answer = new int[arr.size()];
        
        for(int i = 0; i < arr.size(); i++) {
        	answer[i] = arr.get(i);
        }
        
        return answer;
    }
	
	static boolean check(String today, String del_date) {
		String[] today_temp = today.split("\\.");
		String[] exp_temp = del_date.split("\\.");
		
		int today_year = Integer.parseInt(today_temp[0]);
		int today_month = Integer.parseInt(today_temp[1]);
		int today_day = Integer.parseInt(today_temp[2]);
		
		int del_year = Integer.parseInt(exp_temp[0]);
		int del_month = Integer.parseInt(exp_temp[1]);
		int del_day = Integer.parseInt(exp_temp[2]);
		
		if(today_year < del_year) {
			return true;
		}else if(today_year == del_year) {
			if(today_month < del_month) {
				return true;
			}else if(today_month == del_month) {
				if(today_day < del_day) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	static String add_date(String date, int expire_month) {
		String[] temp = date.split("\\.");
		int year = Integer.parseInt(temp[0]);
		int month = Integer.parseInt(temp[1]);
		int day = Integer.parseInt(temp[2]);
		
		if(expire_month >= 12) {
			year += expire_month / 12;
			month += expire_month % 12; 
		}else {
			month += expire_month % 12;
		}
		
		if(month > 12) {
			year++;
			month = month - 12;
		}
		
		String result = String.valueOf(year)+ "." + String.valueOf(month) + "." + String.valueOf(day);
		
		return result;
		
	}

}
