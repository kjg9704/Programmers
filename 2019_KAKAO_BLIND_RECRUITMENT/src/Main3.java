import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Main3 {
	static ArrayList<Integer> preResult;
	static ArrayList<Integer> postResult;
	public static void main(String[] args) {
		int [][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(nodeinfo);
	}
	static class Node{
		int num;
		int x;
		int y;
		Node left;
		Node right;
		Node(){
			
		}
		Node(int num, int x, int y){
			this.num = num;
			this.x = x;
			this.y = y;
			left = null;
			right = null;
		}
	}
	public static int[][] solution(int[][] nodeinfo) {
		int nodeNum = nodeinfo.length;
		Node[] node = new Node[nodeNum];
		HashMap<int[], Integer> map = new HashMap<int[], Integer>();
		preResult = new ArrayList<Integer>();
		postResult = new ArrayList<Integer>();
		int[][] answer = new int [2][nodeNum];
		for(int i = 0; i < nodeNum; i++) {
			map.put(nodeinfo[i], i + 1);
		}
		Arrays.sort(nodeinfo, new Comparator<int[]>() {
		    @Override
			public int compare(int[] o1, int[] o2) {
		    	if(o1[1] == o2[1]) {
		    		return o1[0] - o2[0];
		    		}else {
		    			return o2[1] - o1[1]; 
		    	 }
	           }
	        });
		
		for(int i = 0; i < nodeNum; i++) {
			node[i] = new Node(map.get(nodeinfo[i]), nodeinfo[i][0], nodeinfo[i][1]);
		}
		for(int i = 1; i < node.length; i++) {
			searchPath(node[0], node[i]);
		}
		
		preOrder(node[0]);
		postOrder(node[0]);
		for(int i = 0; i < nodeNum; i++) {
			answer[0][i] = preResult.get(i);
			answer[1][i] = postResult.get(i);
		}
        return answer;
    }
	static void searchPath(Node root, Node child) {
		if(root.x > child.x) {
			if(root.left == null) {
				root.left = child;
			}
			else {
				searchPath(root.left, child);
			}
		}
		else {
			if(root.right == null) {
				root.right = child;
			}
			else {
				searchPath(root.right, child);
			}
		}
	}
	
		
	static void preOrder(Node root) {
		if(root != null) {
			preResult.add(root.num);
			preOrder(root.left);
			preOrder(root.right);
		}
		
	}
	static void postOrder(Node root) {
		if(root != null) {
			postOrder(root.left);
			postOrder(root.right);
			postResult.add(root.num);
		}
	}

}
