import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static class Node{
		int val;
		Node left;
		Node right;
		Node parent;
		public Node() {}
		public Node(int val) {
			this.val = val;
		}
		
		public void setVal(int val) {
			this.val = val;
		}

		public void addChild(Node node) {
			if(this.left == null) this.left = node;
			else				  this.right = node;
		}
		public void setParent(Node node) {
			this.parent = node;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());

		for(int t = 1 ; t <= T; t++) {
			
			
			int N = Integer.parseInt(br.readLine());
	
			int[][] board = new int[N][N];
			
			for(int i = 0 ; i < N; i++) {
				board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				int temp = Math.abs(-i + (N-1)/2);
				for(int x = temp; x < N - temp; x++) {
					 sum += board[i][x];
				}
			}
			System.out.printf("#%d %d\n",t,sum);
		}
	}
	
}