
public class Country124 {

	public static void main(String[] args) {
		int n = 90;
		System.out.println(solution(n));
	}

	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		int current = n;
		int start = 1;
		while(current > 0){
			if(current % 3 == 0){
				if(start == 1) {
					sb.append(3);
					current -= start * 3;
					start *= 3;
				}else if (current / start <= 3) {
					sb.append(current / start);
					current -= (current / start) * start;
					start *= 3;
				}else {
					if(current / start % 3 > 0) {
						sb.append(current / start % 3);
						current -= start * (current / start % 3);
						start *= 3;
					}else {
						sb.append(3);
						current -= start * 3;
						start *= 3;
					}
				}
			} else if(current % 3 > 0) {
				sb.append(current % 3);
				current -= current % 3;
				start *= 3;
			}
		}
		return sb.reverse().toString().replace('3', '4');
	}
}