import java.util.ArrayList;
import java.util.HashSet;

public class Friends4Block {

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		m = 6;
		n = 6;
		String[] board1 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m, n, board1));

	}
	static int solution(int m, int n, String[] board) {
		String[][] matrix = new String[m][n];
		int answer = 0;
		for(int i =0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				matrix[i][j] = board[i].charAt(j) + "";
			}
		}
		boolean check = false;
		do {
			ArrayList<String> list = new ArrayList<String>();
			for(int i = 0; i < m * n; i++) {
				int row = 0;
				int column = 0;
				if(i != 0) {
					row = i / n;
					column = i % n;
				}
				if(row != m - 1 && column != n - 1) {
					if(matrix[row][column].equals(matrix[row][column + 1]) && !matrix[row][column].equals("0")) {
						if(matrix[row][column].equals(matrix[row + 1][column])) {
							if(matrix[row][column].equals(matrix[row + 1][column + 1])) {
								list.add((row + "") +" "+ (column + ""));
								list.add((row + "") +" "+ ((column + 1) + ""));
								list.add(((row + 1) + "") +" "+ (column + ""));
								list.add(((row + 1) + "") +" "+ ((column + 1) + ""));
								check = true;
							}
						}
					}
				}
			}
			if(!check) {
				break;
			}
			HashSet<String> distinctList = new HashSet<String>(list);
	        list = new ArrayList<String>(distinctList);
	        answer += list.size();
	        for(int i = 0; i < list.size(); i++) {
	        	String [] delete = list.get(i).split(" ");
	        	int x = Integer.parseInt(delete[0]);
	        	int y = Integer.parseInt(delete[1]);
	        	matrix[x][y] = "0";
	        }
	        for(int i = m * n - 1; i >= 0; i--) {
				int row = 0;
				int column = 0;
				if(i != 0) {
					row = i / n;
					column = i % n;
				}
				if(matrix[row][column].equals("0")) {
					int upRow = row;
					while(matrix[upRow][column].equals("0")) {
						if(upRow != 0) {
							upRow--;
						}else {
							break;
						}
					}
					if(!matrix[upRow][column].equals("0")) {
						matrix[row][column] = matrix[upRow][column];
						matrix[upRow][column] = "0";
					}
				}
	        }
	        check = false;
		}while(!check);
        return answer;
    }

}
