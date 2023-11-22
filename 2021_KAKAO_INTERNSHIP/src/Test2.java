public class Test2 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int[] result = solution(places);
		for(int i = 0; i < 5; i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i < 5; i++) {
        	answer[i] = solution2(places[i]);
        }
        return answer;
    }
	static int solution2(String[] place) {
		char[][] matrix = new char[5][5];
		for(int i = 0; i < 5; i++) {
			matrix[i] = place[i].toCharArray();
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(matrix[i][j] == 'P') {
					if(!check(matrix, i, j)) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
	static boolean check(char[][] matrix, int x, int y) {
		boolean[][] visited = new boolean[5][5];
		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			if(nextX >= 0 && nextY >= 0 && nextX < 5 && nextY < 5 && visited[nextX][nextY] == false) {
				if(matrix[nextX][nextY] == 'P') {
					return false;
				}else if (matrix[nextX][nextY] == 'X') {
					visited[nextX][nextY] = true;
				}else {
					for(int j = 0; j < 4; j++) {
						int nextX2 = nextX + dx[j];
						int nextY2 = nextY + dy[j];
						if(nextX2 >= 0 && nextY2 >= 0 && nextX2 < 5 && nextY2 < 5 && visited[nextX2][nextY2] == false) {
							if(matrix[nextX2][nextY2] == 'P') {
								return false;
							}else if (matrix[nextX2][nextY2] == 'X') {
								visited[nextX2][nextY2] = true;
							}else if (matrix[nextX2][nextY2] == 'O') {
								visited[nextX2][nextY2] = true;
							}
						}
					}
				}
			}
		}
		return true;
	}

}
