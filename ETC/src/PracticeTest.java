import java.util.ArrayList;

public class PracticeTest {

	//	static int[] one = {1, 2, 3, 4, 5};
	//	static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
	//	static int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
	static int[][] matrix = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		for(int i : solution(answers)) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int[] answers) {
		ArrayList<Integer> list = new ArrayList<>();
		int result = 0;
		for(int i = 0; i < matrix.length; i++) {
			int count = 0;
			int size = matrix[i].length;
			for(int j = 0; j < answers.length; j++) {
				if(answers[j] == matrix[i][j % size]) {
					count++;
				}
			}
			if(count > result) {
				result = count;
				if(list.isEmpty()) {
					list.add(i + 1);
				}else {
					list.clear();
					list.add(i + 1);
				}
			}else if(count == result) {
				list.add(i + 1);
			}
		}
		int[] answer = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

}
