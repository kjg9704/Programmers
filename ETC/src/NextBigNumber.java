
public class NextBigNumber {

	public static void main(String[] args) {
		int n = 6;
		System.out.println(solution2(n));
	}
	
	public static int solution2(int n) {
		String num = Integer.toBinaryString(n);
		int count = 0;
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '1') {
				count++;
			}
		}
		int chkNum = n + 1;
		while(!check(count, chkNum)) {
			chkNum++;
		}
		return Integer.parseInt(Integer.toBinaryString(chkNum),2);
		
	}
	public static boolean check(int count, int b) {
		String num = Integer.toBinaryString(b);
		int count2 = 0;
		for(int i = 0; i < num.length(); i++) {
			if(num.charAt(i) == '1') {
				count2++;
			}
		}
		if(count == count2) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        if(sb.charAt(sb.length() - 1) == '1') {
        	int point = sb.length() - 1;
        	int i = sb.length() - 1;
        	while(true) {
        		if(sb.charAt(point) == '0') {
        			sb.setCharAt(point, '1');
        			sb.setCharAt(i, '0');
        			break;
        		}else {
        			if(point == 0) {
        				sb.setCharAt(point, '0');
        				sb.insert(point, '1');
        				break;
        			}
        			i = point;
        			point--;
        		}
        	}
        }else {
        	int point = sb.lastIndexOf(String.valueOf('1'));
        	int start = point;
        	while(sb.charAt(point) != '0') {
        		if(point == 0) {
        			sb.append('0');
        			break;
        		}
        		point--;
        	}
        	if(point == start) {
        		return Integer.parseInt(sb.toString(),2);
        	}
        	if(point == 0) {
        		while(sb.charAt(sb.length() - 1) == '0') {
            		sb.insert(point + 1, '0');
            		sb.deleteCharAt(sb.length() - 1);
            	}
        		return Integer.parseInt(sb.toString(),2);
        	}
        	sb.setCharAt(point, '1');
        	sb.setCharAt(point + 1, '0');
        	int i = sb.lastIndexOf(String.valueOf('1'));
        	point++;
        	if(i > point) {
        		while(sb.charAt(sb.length() - 1) == '0') {
            		sb.insert(point + 1, '0');
            		sb.deleteCharAt(sb.length() - 1);
            	}
        	}
        }
        return Integer.parseInt(sb.toString(),2);
    }

}
