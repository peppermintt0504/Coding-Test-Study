import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static class PriorityQ{
		Node root;
		int tail;
		Map<Integer,Node> memo = new HashMap<>();
		
		public PriorityQ() {
			tail = 1;
		}
		
		public void addNode(Node node) {
			
			if(root == null) {
				this.root = node;
				root.no = tail;
				memo.put(tail, root);
				tail++;
				return;
			}
			
			if(tail % 2 == 0) {
				Node parent = memo.get(tail/2);
				parent.left = node;
				node.parent = parent;
				node.no = tail;
			}else {
				Node parent = memo.get((tail-1)/2);
				parent.right = node;
				node.parent = parent;
				node.no = tail;
			}
			memo.put(tail, node);
			
			compareToParent(node);
			
			tail++;
			
			
		}
		
		public int poll() {
			if(tail == 1)return -1;
			
			int pollValue = root.val;
			
			if(tail == 2) {
				tail--;
				root = null;
				return pollValue;
			}
			
			tail--;
			Node target = memo.get(tail);
			
			int tailVal = target.val;

			root.val = tailVal;
			
			boolean isLeft = target.parent.isLeft(target.val);
			if(isLeft)target.parent.left = null;
			else	  target.parent.right = null;
			target = null;
			memo.remove(tail);
			compareToParentReverse(root);
			
			return pollValue;
		}
		
		public void compareToParent(Node node) {
			if(node.no == 1)return;
			Node parent = node.parent;
			
			if(node.compareTo(parent) > 0) {
				int temp = node.val;
				node.val = parent.val;
				parent.val = temp;
				
				compareToParent(parent);
			}
		}
		
		public void compareToParentReverse(Node node) {
			if(node.left == null && node.right == null)return;
			boolean needChange = false;
			
			if(node.left != null && node.compareTo(node.left) < 0) needChange = true;
			if(node.right != null && node.compareTo(node.right) < 0) needChange = true;
			
			if(!needChange)return;
			
			boolean leftIsMore = true;
			

			if(node.right != null && node.right.compareTo(node.left) > 0) {
				leftIsMore = false;
				
			}
			if(leftIsMore) {
				if(node.compareTo(node.left) < 0) {
					Node A = node.left;
					
					int temp = A.val;
					A.val = node.val;
					node.val = temp;
					compareToParentReverse(A);
				}
			}else {
				if(node.compareTo(node.right) < 0) {
					Node A = node.right;
					
					int temp = A.val;
					A.val = node.val;
					node.val = temp;
					compareToParentReverse(A);
				}
			}
			
		}
	}
	
	public static class Node implements Comparable<Node>{
		int val;
		Node left;
		Node right;
		Node parent;
		int no;
		
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
		public boolean isLeft(int value) {
			return left == null ? false : left.val == value ? true : false; 
		}
		
		@Override
		public String toString() {
			return "Node No" + no + "[val=" + val + " ,left =" + (left == null? null : left.val) + " ,right = " +  (right == null? null : right.val) + "]";
		}
		@Override
		public int compareTo(Node o1) {
			
			return Integer.compare(this.val, o1.val);
		}
	}
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());

		for(int t = 1 ; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			PriorityQ pq = new PriorityQ();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				int C = Integer.parseInt(st.nextToken());
				
				if(C == 1) {
					pq.addNode(new Node(Integer.parseInt(st.nextToken())));
				}else {
					int num = pq.poll();
					sb.append(num + " ");
				}
//				for(int n : pq.memo.keySet()) {
//					System.out.println(pq.memo.get(n));
//				}
//				System.out.println();
			}
			System.out.printf("#%d %s\n",t,sb.toString().trim());
		}
	}
	
}