
public class Main {
	static int [][] map;
	static int [][] answer;
	public static void main(String[] args) {
		int [][] build_frame = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		solution(5, build_frame);
		for(int i = 0; i < map.length;i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	static boolean insertCheck(int x, int y, int obj) {
		if(obj == 0) { //±âµÕ
			if(y != 0) {
				if(map[x + 1][y - 1 + 1] == 0 && map[x - 1 + 1][y - 1 + 1] != 2) {
					return false;
				}
			}
			return true;
		}
		else { //º¸
			if(map[x + 1][y - 1 + 1] == 1 || map[x + 1][y - 1 + 1] == 3 || map[x + 1 + 1][y - 1 + 1] == 1 || map[x + 1 + 1][y - 1 + 1] == 3) {
				return true;
			}
			else {
				if((map[x - 1 + 1][y + 1] == 2 || map[x - 1 + 1][y + 1] == 3) && (map[x + 1 + 1][y + 1] == 2 || map[x + 1 + 1][y + 1] == 3)) {
					return true;
				}
				return false;
			}
		}
	}
	static boolean deleteCheck(int x, int y, int obj) {
		if(obj == 0) { //±âµÕ
			if(map[x + 1][y + 1 + 1] == 2 || map[x + 1][y + 1 + 1] == 3) {
				if((map[x - 1 + 1][y + 1 + 1] == 2 || map[x - 1 + 1][y + 1 + 1] == 3) && (map[x + 1 + 1][y + 1 + 1] == 2 || map[x + 1 + 1][y + 1 + 1] == 3)) {
					return true;
				}
				if(map[x + 1 + 1][y + 1] == 1 || map[x + 1 + 1][y + 1] == 3) {
					return true;
				}
				return false;
			}
			else {
				if(map[x + 1][y + 1 + 1] == 1) {
					if(map[x - 1 + 1][y + 1 + 1] == 2 || map[x - 1 + 1][y + 1 + 1] == 3) {
						return true;
					}
				}
				return false;
			}
		}
		else { //º¸
			if(map[x + 1 + 1][y + 1] == 2 || map[x + 1 + 1][y + 1] == 3) {
				if(map[x + 1 + 1][y - 1 + 1] == 1 || map[x + 1 + 1][y - 1 + 1] == 3) {
					if(map[x - 1 + 1][y + 1] == 2 || map[x - 1 + 1][y + 1] == 3) {
						if(map[x - 1 + 1][y - 1 + 1] == 1 || map[x - 1 + 1][y - 1 + 1] == 3) {
							return true;
						}
					}
				}
				return false;
			}
			if(map[x + 1 + 1][y + 1] == 1 || map[x + 1][y + 1] == 3) {
				if(map[x + 1 + 1][y - 1 + 1] == 1 || map[x + 1 + 1][y - 1 + 1] == 3) {
					if(map[x + 1][y + 1] != 3) {
						return true;
					}
					return false;
				}
				if(map[x + 1][y - 1 + 1] == 1 || map[x + 1][y - 1 + 1] == 3) {
					return true;
				}
				
			}
			return true;
		}
	}
	static int[][] solution(int n, int [][] build_frame) {
		answer = new int [n + 2][n + 2];
		int row = build_frame.length;
		map = new int[n + 2][n + 2];
		for(int i = 0; i < row; i++) {
			if(build_frame[i][2] == 0) { // 0 = ±âµÕ, 1 = º¸
				if(build_frame[i][3] == 0) { // 0 = »èÁ¦, 1 = »ðÀÔ
					if(deleteCheck(build_frame[i][0], build_frame[i][1], 0)) {
						if(map[build_frame[i][0] + 1][build_frame[i][1] + 1] != 3) {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 0;
						}
						else {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 2;
						}
					}
				}
				else {
					if(insertCheck(build_frame[i][0], build_frame[i][1], 0)) {
						if(map[build_frame[i][0] + 1][build_frame[i][1] + 1] != 2) {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 1;
						}
						else {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 3;
						}
						
					}
				}
			}
			else {
				if(build_frame[i][3] == 0) { // 0 = »èÁ¦, 1 = »ðÀÔ
					if(deleteCheck(build_frame[i][0], build_frame[i][1], 1)) {
						if(map[build_frame[i][0] + 1][build_frame[i][1] + 1] != 3) {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 0;
						}
						else {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 1;
						}
					}
				}
				else {
					if(insertCheck(build_frame[i][0], build_frame[i][1], 1)) {
						if(map[build_frame[i][0] + 1][build_frame[i][1] + 1] != 1) {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 2;
						}
						else {
							map[build_frame[i][0] + 1][build_frame[i][1] + 1] = 3;
						}
					}
				}
			}
		}
		return answer;
	}

}
