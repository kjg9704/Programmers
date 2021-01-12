import java.util.ArrayList;
import java.util.regex.Pattern;

public class News {

	public static void main(String[] args) {
		String str1 = "bcdaaaa";
		String str2 = "aaazxnm";
		System.out.println(solution(str1, str2));
	}
	static int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> set1 = new ArrayList<String>();
        ArrayList<String> set2 = new ArrayList<String>();
        for(int i = 0; i < str1.length() - 1; i++) {
        	String a = str1.charAt(i) + "";
        	String b = str1.charAt(i + 1) + "";
        	String subStr = a + b;
        	if(Pattern.matches("^[a-zA-Z]*$", subStr)){
        		set1.add(subStr.toUpperCase());
        	}
        }
        for(int i = 0; i < str2.length() - 1; i++) {
        	String a = str2.charAt(i) + "";
        	String b = str2.charAt(i + 1) + "";
        	String subStr = a + b;
        	if(Pattern.matches("^[a-zA-Z]*$", subStr)){
        		set2.add(subStr.toUpperCase());
        	}
        }
        ArrayList<String> retainSet = new ArrayList<String>();
        ArrayList<String> unionSet = new ArrayList<String>(set1);
        unionSet.addAll(set2);
        for (String t : set1) {
            if (set2.contains(t)) {
            	set2.remove(t);
                retainSet.add(t);
            }
        }
        int size1 = retainSet.size();
        int size2 = unionSet.size() - size1;
        double zakad;
        if(size2 != 0) {
        	zakad = (double)size1 / (double)size2;
        }
        else {
        	zakad = 1;
        }
        answer = (int) (zakad * 65536);
        return answer;
    }

}
