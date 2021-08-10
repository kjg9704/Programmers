
public class Week02 {

	public static void main(String[] args) {
		int[][] scores = {{100,90,98,88,65},
						{50,45,99,85,77},
						{47,88,95,80,67},
						{61,57,100,80,65},
						{24,90,94,75,65}};
		System.out.println(solution(scores));
	}
	
	public static String solution(int[][] scores) {
		int num = scores.length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < num; i++) {
			int sum = 0;
			boolean maxDupl = false;
			boolean minDupl = false;
			int max = 0;
			int min = Integer.MAX_VALUE;
			int self = scores[i][i];
			int count = num;
			for(int j = 0; j < num; j++) {
				int score = scores[j][i];
				sum += score;
				if(max < score) {
					max = score;
				}else if(max == score) {
					maxDupl = true;
				}
				if(min > score) {
					min = score;
				}else if(min == score) {
					minDupl = true;
				}
			}
			
			if(max == self) {
				if(!maxDupl) {
					sum -= self;
					count--;
				}
			}else if(min == self) {
				if(!minDupl) {
					sum -= self;
					count--;
				}
			}
			double avg = sum / count;
			sb.append(getGrade(avg));
		}
		
        return sb.toString();
    }
	
	static char getGrade(double avg) {
		if(avg >= 90) {
			return 'A';
		}else if(avg >= 80) {
			return 'B';
		}else if(avg >= 70) {
			return 'C';
		}else if(avg >= 50) {
			return 'D';
		}else {
			return 'F';
		}
	}

}
