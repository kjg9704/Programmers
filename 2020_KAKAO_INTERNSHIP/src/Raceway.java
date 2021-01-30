import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
class Node{
	Point point;
	String direction;
	int cost;
	public Node(Point point, int cost, String direction) {
		this.point = point;
		this.cost = cost;
		this.direction = direction;
	}
}
class nodeCost{
	int cost;
	String direction;
	public nodeCost(int cost, String direction) {
		this.cost = cost;
		this.direction = direction;
	}
}
public class Raceway {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static nodeCost [][] results;
	public static void main(String[] args) {
	//	int [][] board = {{0,0,0},{0,0,0},{0,0,0}};
		int [][] board = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
	//	int [][] board = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
	//	int [][] board = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
//		int[][] board = {
//		        {0, 0, 0, 0, 0},
//		        {0, 1, 1, 1, 0},
//		        {0, 0, 1, 0, 0},
//		        {1, 0, 0, 0, 1},
//		        {0, 1, 1, 0, 0}
//		    };
		System.out.println(solution(board));
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				System.out.print(results[i][j].cost + " ");
			}
			System.out.println();
		}
	}
	public static int solution(int[][] board) {
		int answer = 0;
		int N = board.length;
		Point point = new Point(0, 0);
		results = new nodeCost[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				results[i][j] = new nodeCost(Integer.MAX_VALUE, "");
			}
		}
		bfs(point, board);
		answer = results[N - 1][N - 1].cost;
		return answer;
	}
	static void bfs(Point point, int[][] board) {
		Queue<Node> que = new LinkedList<Node>();
		int nowX = point.x;
		int nowY = point.y;
		results[nowX][nowY].cost = 0;
		que.add(new Node(point, 0, ""));
		while(!que.isEmpty()) {
			nowX = que.peek().point.x;
			nowY = que.peek().point.y;
			int nowCost = que.peek().cost;
			String nowDirection = que.poll().direction;
			if(results[nowX][nowY].cost != nowCost) {
				continue;
			}
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= board.length || nextY >= board.length || board[nextX][nextY] == 1) {
					continue;
				}
				String nextDirection = "";
				switch(dx[i]) {
				case 1:
					nextDirection = "down";
					break;
				case -1:
					nextDirection = "up";
					break;
				}
				switch(dy[i]) {
				case 1:
					nextDirection = "right";
					break;
				case -1:
					nextDirection = "left";
					break;
				}
				int addCost = 0;
				if(nowDirection.equals("")) {
					addCost = 100;
				}
				else if(nowDirection.equals(nextDirection)) {
					addCost = 100;
				}
				else if(!nowDirection.equals(nextDirection)) {
					addCost = 600;
				}
				int cost = results[nowX][nowY].cost + addCost;
				if(results[nextX][nextY].cost >= cost) {
					results[nextX][nextY].cost = cost;
					results[nextX][nextY].direction = nextDirection;
				}
				que.add(new Node(new Point(nextX, nextY), cost, nextDirection));
			}
		}
	}
}
