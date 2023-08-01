import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	public static class Node{
		Node left;
		Node right;
		int num;
		
		public Node(int num) {
			left = null;
			right = null;
			this.num = num;
		}
		
		public void setLeft(Node LN) {
			left = LN;
		}
		
		public void setRight(Node RN) {
			right = RN;
		}
		
		public void addNode(Node newNode) {
			if(this.num > newNode.num) {
				if(this.left == null) {
					this.left = newNode;
				}else {
					this.left.addNode(newNode);
				}
			}else {
				if(this.right == null) {
					this.right = newNode;
				}else {
					this.right.addNode(newNode);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		Node root = new Node(Integer.parseInt(br.readLine()));
		
		while(true) {
			String temp = br.readLine();
			
			if(temp == null || temp.equals(""))break;
			root.addNode(new Node(Integer.parseInt(temp)));
			
		}
		preoder(root);
	}
	
	public static void preoder(Node N) {
		if(N == null)
			return;
		
		preoder(N.left);
		preoder(N.right);
		System.out.println(N.num);
	}
	
}


