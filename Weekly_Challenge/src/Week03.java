import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point implements Comparable<Point>{
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//오름차순 정렬을위한 Comparable 구현
	@Override
	public int compareTo(Point o) {
		if(this.x < o.x) {
			return -1;
		}else if(this.x > o.x) {
			return 1;
		}else {
			if(this.y < o.y) {
				return -1;
			}else if(this.y > o.y) {
				return 1;
			}
		}
		return 0;
	}
}
public class Week03 {

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		int[][] game_board = {{1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}};
		int[][] table = {{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}};
		System.out.println(solution(game_board, table));
	}
	
	public static int solution(int[][] game_board, int[][] table) {
        ArrayList<Point[]> Blocks = new ArrayList<>();
        ArrayList<Point[]> EmptyBlocks = new ArrayList<>();
        int tableLen = table.length;
        boolean[][] visited = new boolean[tableLen][tableLen];
        
        //table에서 블록을 찾음
        for(int i = 0; i < tableLen; i++) {
        	for(int j = 0; j < tableLen; j++) {
        		if(table[i][j] == 1 && !visited[i][j]) {
        			Blocks.add(getBlock(table, i, j, visited, 1));
        		}
        	}
        }
        visited = new boolean[tableLen][tableLen];
        //game_board 에서 빈칸을 찾음
        for(int i = 0; i < tableLen; i++) {
        	for(int j = 0; j < tableLen; j++) {
        		if(game_board[i][j] == 0 && !visited[i][j]) {
        			EmptyBlocks.add(getBlock(game_board, i, j, visited, 0));
        		}
        	}
        }
        int result = 0;
        boolean[] used = new boolean[Blocks.size()];
        //찾은 빈칸, 블록 리스트를 돌면서 빈칸블록을 채움
        for(int i = 0; i < EmptyBlocks.size(); i++) {
        	for(int j = 0; j < Blocks.size(); j++) {
        		boolean flag = false;
        		if(EmptyBlocks.get(i).length == Blocks.get(j).length && !used[j]) {//만약 빈칸수 == 블록수 이면 4회 회전하면서 채을수 있는지 확인
        			Point[] RotateBlock = Blocks.get(j);
        			for(int z = 0; z < 4; z++) {
        				RotateBlock = rotate(RotateBlock);
        				if(Check(EmptyBlocks.get(i), RotateBlock)) {
        					used[j] = true;
        					result += RotateBlock.length;
        					flag = true;
        					break;
        				}
        			}
        			if(flag) break;
        		}
        	}
        }
        return result;
    }
	
	//solution함수의 for문에서 찾은 블록부터 bfs돌려서 연결된 블록을 찾고 오름차순으로 정렬 후 0,0 기준 좌표로 정렬
	static Point[] getBlock(int[][] table, int x, int y, boolean[][] visited, int type){
		ArrayList<Point> points = new ArrayList<>();
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x, y));
		visited[x][y] = true;
		points.add(new Point(x, y));
		while(!que.isEmpty()) {
			Point now = que.poll();
			for(int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				if(nextX >= 0 && nextX < table.length && nextY >= 0 && nextY < table.length && table[nextX][nextY] == type && !visited[nextX][nextY]) {
					visited[nextX][nextY] = true;
					que.add(new Point(nextX, nextY));
					points.add(new Point(nextX, nextY));
				}
			}
		}
		Point[] p = new Point[points.size()];
		p = (Point[]) points.toArray(p);
		Arrays.sort(p);
		return BlockSort(p);
	}
	
	//블록의 좌표를 0,0 기준으로 바꿈
	static Point[] BlockSort(Point[] arr) {
		int tempx = arr[0].x;
		int tempy = arr[0].y;
		for(int i = 1; i < arr.length; i++) {
			tempy = Math.min(tempy, arr[i].y);
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i].x -= tempx;
			arr[i].y -= tempy;
		}
		return arr;
	}
	
	//블록을 시계방향으로 90도 회전
	static Point[] rotate(Point[] block) {
		int height = block[block.length - 1].x;
		Point[] temp = new Point[block.length];
		for(int i = 0; i < block.length; i++) {
			Point p = new Point(block[i].y, height - block[i].x);
			temp[i] = p;
		}
		Arrays.sort(temp);
		return temp;
	}
	
	//빈칸과 블록이 일치하는지 확인
	static boolean Check(Point[] empty, Point[] block) {
		for(int i = 0; i < empty.length; i++) {
			if(empty[i].x != block[i].x || empty[i].y != block[i].y) {
				return false;
			}
		}
		return true;
	}

}