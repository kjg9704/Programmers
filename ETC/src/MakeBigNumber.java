
public class MakeBigNumber {

	public static void main(String[] args) {
		String number = "99";
		int k = 1;
		System.out.println(solution(number, k));
	}
	
	public static String solution(String number, int k) {
        int count = 0;
        StringBuilder sb = new StringBuilder(number);
        int i = 0;
        while(count != k) {
        	int length = sb.length();
        	if(i + 1 < length) {
        		if(sb.charAt(i) - '0' > sb.charAt(i + 1) - '0') {
            		sb.deleteCharAt(i + 1);
            		count++;
            		if(i > 0) i++;
            	}else if(sb.charAt(i) - '0' < sb.charAt(i + 1) - '0') {
            		sb.deleteCharAt(i);
            		count++;
            	}else {
            		i++;
            	}
        	}else {
        		sb.deleteCharAt(i);
        		count++;
        	}
        }
        return sb.toString();
    }

}