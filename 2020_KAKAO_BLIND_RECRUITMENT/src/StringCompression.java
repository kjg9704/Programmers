
public class StringCompression {

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaba";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = s.length();
		int size = s.length();
		for(int i = 1; i <= size / 2; i++) {
			int count = 0;
			for(int j = 0; j < size; j += i) {
				String sub;
				if(j + i < size) {
					sub = s.substring(j, j + i);
				}else {
					sub = s.substring(j);
				}
				int index = j + i;
				int cnt = 0;
				while(s.startsWith(sub, index)) {
					index += i;
					cnt++;
				}
				if(cnt > 0) {
					count += cnt * i - (String.valueOf(cnt + 1).length());
					j = index - i;
				}
			}
			answer = Math.min(answer, size - count);
		}
		return answer;
	}
}