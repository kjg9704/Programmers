
public class StringCompression {

	public static void main(String[] args) {
		String s = "abcabcabcabcdededededede";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
        int answer = 0;
        int size = s.length();
        for(int i = 1; i <= size / 2; i++) {
        	int count = 0;
        	for(int j = 0; j < size; j += i) {
        		String sub = s.substring(j, j + i);
        		if(s.startsWith(sub, j + i)) {
        			int index = j + i;
        			int cnt = 1;
        			while(index)
        			
        		}
        		
        	}
        }
        return answer;
    }

}
