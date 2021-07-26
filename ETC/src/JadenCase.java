
public class JadenCase {

	public static void main(String[] args) {
		String s = "3people unFollowed me";
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(s.charAt(0)).toUpperCase());
        for(int i = 1; i < s.length(); i++) {
        	if(s.charAt(i) == ' ') {
        		sb.append(String.valueOf(s.charAt(i)));
        	}else {
        		if(s.charAt(i - 1)== ' ') {
        			sb.append(String.valueOf(s.charAt(i)).toUpperCase());
        		}else {
        			sb.append(String.valueOf(s.charAt(i)).toLowerCase());
        		}
        	}
        }
        return sb.toString();
    }

}
