import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class nextPoint {
	int point;
	int cost;
	public nextPoint(int point, int cost) {
		this.point = point;
		this.cost = cost;
	}
}
public class Taxi {

	static final int INF = 9999999;
	public static void main(String[] args) {
		int n = 6;	
		int s = 4;
		int a = 6;
		int b = 2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.println(solution(n, s, a, b, fares));
	}
	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int[][] matrix = new int[n + 1][n + 1];
		for(int[] temp : matrix) {
			Arrays.fill(temp, INF);
		}
		for(int i = 1; i <= n; i++) {
			matrix[i][i] = 0;
		}
		for(int i = 0; i < fares.length; i++) {
			int start = fares[i][0];
			int end = fares[i][1];
			int cost = fares[i][2];
			matrix[start][end] = cost;
			matrix[end][start] = cost;
		}
		for (int k = 1; k <= n; ++k) { // 경유지 
			for (int i = 1; i <= n; ++i) { // 출발지 
				if(i==k) continue; // 경유지와 출발지가 같다면 패스 
				for (int j = 1; j <= n; ++j) { // 도착지
					if(j==k || i==j) continue; // 경유지와 도착지가 같거나 출발지와 도착지가 같다면 패스 
					if(matrix[i][k]+matrix[k][j] < matrix[i][j]) { 
						matrix[i][j] = matrix[i][k]+matrix[k][j];
						}
					} 
				}
		}
		Queue<nextPoint> que = new LinkedList<nextPoint>();
		boolean[] visited = new boolean[n + 1];
		que.add(new nextPoint(s, 0));
		int result = 0;
		while(!que.isEmpty()) {
			int start = que.peek().point;
			int startCost = que.poll().cost;
			visited[start] = true;
			int cost = 0;
			for(int i = 1; i <= n; i++) {
				if(matrix[start][i] != 0 && visited[i] == false) {
					que.add(new nextPoint(i, matrix[start][i] + startCost));
				}
				if(i == a || i == b) {
					cost += matrix[start][i];
				}
			}
			if(result == 0) {
				result += startCost + cost;
			}
			else {
				result = Math.min(result, startCost + cost);
			}
		}
		int answer = result;
		return answer;
	}
}
