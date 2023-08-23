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
		boolean isInteger = false;
		
		public Node() {}
		
		public void setVal(String val) {
			this.val = val;
			if(val.codePointAt(0) >=48) isInteger = true;
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
			System.out.println(calcVal(memo.get(1)));
		}
		
		
	}
	public static void printInOrder(Node tree) {
		if(tree.left != null)printInOrder(tree.left);
		System.out.print(tree.isInteger ? tree.val : tree.val);
		if(tree.right != null)printInOrder(tree.right);
	}
	public static int calcVal(Node tree) {
		int LV = 0;
		int RV = 0;
		
		
		if(tree.left.isInteger) {
			LV = Integer.parseInt(tree.left.val);
		}else {
			LV = calcVal(tree.left);
		}
		
		if(tree.right.isInteger) {
			RV = Integer.parseInt(tree.right.val);
		}else {
			RV = calcVal(tree.right);
		}
		
		if(tree.val.equals("+")) {
			return LV + RV;
		}else if(tree.val.equals("-")) {
			return LV - RV;
		}
		else if(tree.val.equals("*")) {
			return LV * RV;
		}else {
			return LV/RV;
		}
	}
}