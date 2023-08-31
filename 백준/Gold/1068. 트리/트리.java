import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;
	
	public static class Node{
		int val;
		Node parent;
		ArrayList<Node> children = new ArrayList<>();
		public Node() {}
		public Node(int v) {
			val = v;
		}
		
		public void addChild(Node c) {
			children.add(c);
		}
		public int countLeap() {
			int count = 0;
			
			if(children.size() == 0) 
			{
				return 1;
			}else {
				for(Node n : children) {
					count += n.countLeap();
				}
			}
			return count;
		}
		public void removeChild(Node c) {
			children.remove(c);
		}

		@Override
		public String toString() {
			return "Node "+ val +" [parent=" + parent + ", children=" + children.size() + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] nodes = new Node[N];
		
		for(int i = 0; i < N;i++) {
			nodes[i] = new Node(i);
        	
        }
       
        int[] tree = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int root = 0;
        
        for(int i = 0; i < N;i++) {
        	if(tree[i] == -1) {
        		root = i;
        		continue;
        	}
        	nodes[i].parent = nodes[tree[i]];
        	nodes[tree[i]].children.add(nodes[i]);
        }
        int removeNum =Integer.parseInt(br.readLine());
        Node removeNode = nodes[removeNum];
        
        
        if(removeNum == root) {
        	System.out.println(0);
        	return;
        }
        if(removeNode.parent!=null)removeNode.parent.removeChild(removeNode);
        
        System.out.println(nodes[root].countLeap());
        
	}
   
}

