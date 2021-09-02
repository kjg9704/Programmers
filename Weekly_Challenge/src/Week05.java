
public class Week05 {

	public static void main(String[] args) {
	//	String word = "EIO";
		String word = "AAAAE";
	//	String word = "I";
		System.out.println(solution(word));
	}
	
	public static int solution(String word) {
		char[] list = {'A', 'E', 'I', 'O', 'U'};
		int[] list2 = {781, 156, 31, 6, 1};
		int answer = 0;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			for(int j = 0; j < 5; j++) {
				if(c == 'A') {
					answer += 1;
					break;
				}else if(c == list[j]) {
					answer += 1;
					answer += list2[i] * j;
					break;
				}
			}
		}
        return answer;
    }
}