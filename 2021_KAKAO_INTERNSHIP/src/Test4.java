import java.util.*;


class Node implements Comparable<Node>{
	int node;
	int cost;
	public Node(int node, int cost) {
		this.node = node;
		this.cost = cost;
	}
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}
public class Test4 {

	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int n = 4;
		int start = 1;
		int end = 4;
		int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
		int[] traps = {2, 3};
		System.out.println(solution(n, start, end, roads, traps));
	}
	
	public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int[][] matrix = new int[n + 1][n + 1];
        boolean [] isTrap = new boolean[n + 1];
        boolean[] visited = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
        	Arrays.fill(matrix[i], -1);
        }
        for(int i = 0; i < roads.length; i++) {
        	int startNode = roads[i][0];
        	int endNode = roads[i][1];
        	int cost = roads[i][2];
        	if(matrix[startNode][endNode] > 0) {
        		matrix[startNode][endNode] = Math.min(matrix[startNode][endNode], cost);
        	}else if(matrix[startNode][endNode] == -1){
        		matrix[startNode][endNode] = cost;
        		matrix[endNode][startNode] = 0;
        	}else {
        		matrix[startNode][endNode] = cost;
        	}
        }
        for(int i = 0; i < traps.length; i++) {
        	isTrap[traps[i]] = true;
        }
        int [] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        Queue<Node> pq = new LinkedList<>();
        pq.add(new Node(start, 0));
        Node now;
        while (!pq.isEmpty()) {
            now = pq.poll(); // 시작 정점
            int nowNode = now.node; // 시작 정점이 가진 다음 정점
            int nowCost = now.cost; // 시작 정점이 가진 가중치

            if(isTrap[nowNode]) {
    			for(int i = 1; i <= n; i++) {
    				if(matrix[nowNode][i] >= 0) {
    					int temp = matrix[nowNode][i];
    					matrix[nowNode][i] = matrix[i][nowNode];
    					matrix[i][nowNode] = temp;
    				}
    			}
    		}
            if(isTrap[nowNode]) {
    			for(int i = 1; i <= n; i++) {
    				if(matrix[nowNode][i] > 0 && answer > nowCost + matrix[nowNode][i]) {
    					if(i == end) {
            				distance[i] = nowCost + matrix[nowNode][i];
            			}else {
            				distance[i] = nowCost + matrix[nowNode][i];
                			pq.add(new Node(i, distance[i]));
            			}
    				}
    			}
    		}else {
    			for (int i = 1; i <= n; i++) {
                	if(matrix[nowNode][i] > 0) {
                		if(distance[i] > nowCost + matrix[nowNode][i] && distance[end] > nowCost + matrix[nowNode][i]) {
                			if(i == end) {
                				distance[i] = nowCost + matrix[nowNode][i];
                			}else {
                				distance[i] = nowCost + matrix[nowNode][i];
                    			pq.add(new Node(i, distance[i]));
                			}
                		}else if(isTrap[i] && distance[end] > nowCost + matrix[nowNode][i]) {
                			pq.add(new Node(i, nowCost + matrix[nowNode][i]));
                		}
                	}
                }
    		}
            
        }
        answer = distance[end];
        return answer;
    }
	static void dfs(int n, int start, int end, int[][] matrix, boolean[] isTrap, boolean[] visited, int cost) {
		if(isTrap[start]) {
			for(int i = 1; i <= n; i++) {
				if(matrix[start][i] >= 0) {
					int temp = matrix[start][i];
					matrix[start][i] = matrix[i][start];
					matrix[i][start] = temp;
				}
			}
		}
		if(matrix[start][end] > 0) {
			answer = Math.min(answer, cost + matrix[start][end]);
		}
		if(isTrap[start]) {
			for(int i = 1; i <= n; i++) {
				if(matrix[start][i] > 0 && answer > cost + matrix[start][i]) {
					dfs(n, i, end, matrix, isTrap, visited, cost + matrix[start][i]);
				}
			}
		}else {
			for(int i = 1; i <= n; i++) {
				if(matrix[start][i] > 0) {
					if(!visited[i] && answer > cost + matrix[start][i]) {
						visited[i] = true;
						dfs(n, i, end, matrix, isTrap, visited, cost + matrix[start][i]);
						visited[i] = false;
					}else if(isTrap[i] && answer > cost + matrix[start][i]) {
						dfs(n, i, end, matrix, isTrap, visited, cost + matrix[start][i]);
					}
				}
				
			}
		}
	}

}
