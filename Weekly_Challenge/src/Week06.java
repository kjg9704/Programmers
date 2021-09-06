import java.util.Arrays;

class Boxer implements Comparable<Boxer>{
	int num;
	int weight;
	double percent;
	int heavyWin;
	
	public Boxer(int num, int weight, double percent, int heavyWin) {
		this.num = num;
		this.weight = weight;
		this.percent = percent;
		this.heavyWin = heavyWin;
	}

	@Override
	public int compareTo(Boxer o) {
		if(this.percent != o.percent) {
			if(this.percent > o.percent) {
				return -1;
			}else {
				return 1;
			}
		}
		if(this.heavyWin != o.heavyWin) {
			return  o.heavyWin - this.heavyWin;
		}
		if(this.weight != o.weight) {
			return  o.weight - this.weight;
		}
		return this.num - o.num;
	}
}
public class Week06 {

	public static void main(String[] args) {
		int[] weights = {50,82,75,120};
		String[] head2head = {"NLWL","WNLL","LWNW","WWLN"};
//		int[] weights = {60,70,60};
//		String[] head2head = {"NNN","NNN","NNN"};
		for(int i : solution(weights, head2head)) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] solution(int[] weights, String[] head2head) {
        Boxer[] boxers = new Boxer[weights.length];
        for(int i = 0; i < weights.length; i++) {
        	int win = 0;
        	int heavyWin = 0;
        	int match = 0;
        	for(int j = 0; j < weights.length; j++) {
        		char result = head2head[i].charAt(j);
        		if(result == 'L') {
        			match++;
        		}else if(result == 'W') {
        			win++;
        			match++;
        			if(weights[i] < weights[j]) {
        				heavyWin++;
        			}
        		}
        	}
        	double percent;
        	if(match == 0) {
        		percent = 0;
        	}else {
        		percent = (double) win / (double) match;
        	}
        	boxers[i] = new Boxer(i + 1, weights[i], percent, heavyWin);
        }
        Arrays.sort(boxers);
        int[] answer = new int[weights.length];
        for(int i = 0; i < weights.length; i++) {
        	answer[i] = boxers[i].num;
        }
        return answer;
    }

}
