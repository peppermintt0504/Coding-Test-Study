import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static class Node{
		String val;
		Node left;
		Node right;
		
		public Node() {}
		public Node(String val) {
			this.val = val;
		}
		
		public void setVal(String val) {
			this.val = val;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public void setRight(Node right) {
			this.right = right;
		}
	}
	
	public static void main(String[] args) throws IOException{
//		int T = Integer.parseInt(br.readLine());
		int T = 10;

		for(int t = 1 ; t <= T; t++) {
			Map<Integer, Node> memo = new HashMap<>();
			
			int N = Integer.parseInt(br.readLine());
			
			for(int x = 1 ; x <= N; x++) {
				memo.put(x, new Node());
			}
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int num = Integer.parseInt(st.nextToken());
				String ch = st.nextToken();
				Node cur = memo.get(num);
				cur.setVal(ch);
				int left = 0;
				int right = 0;
				
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					cur.setLeft(memo.get(left));
				}
				if(st.hasMoreTokens()) {
					right = Integer.parseInt(st.nextToken());
					cur.setRight(memo.get(right));
				}
			}
			
			System.out.printf("#%d ",t);
			printInOrder(memo.get(1));
			System.out.println();
		}
		
		
	}
	public static void printInOrder(Node tree) {
		if(tree.left != null)printInOrder(tree.left);
		System.out.print(tree.val);
		if(tree.right != null)printInOrder(tree.right);
	}
}