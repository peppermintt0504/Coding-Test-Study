import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static Map<Integer,Node> memo = new HashMap<>();
	public static Map<Integer,ArrayList<Integer>> nodes = new HashMap<>();

	public static class Node {
		int no;
        Node parent;
        ArrayList<Node> children = new ArrayList<>();

        public Node(){
        }
        public Node(int n){
        	this.no = n;
        }
  
        public void addChild(Node c) {
        	this.children.add(c);
        }

		@Override
		public String toString() {
			return "Node [parent=" + parent + ", children=" + children + "]";
		}
		
    }
	
	public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i < T; i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            
            if(nodes.containsKey(a)) {
            	nodes.get(a).add(b);
            }else {
            	ArrayList<Integer> temp = new ArrayList<>();
            	temp.add(b);
            	nodes.put(a, temp);
            }
            
            if(nodes.containsKey(b)) {
            	nodes.get(b).add(a);
            }else {
            	ArrayList<Integer> temp = new ArrayList<>();
            	temp.add(a);
            	nodes.put(b, temp);
            }
            
        }
        
        Queue<Integer> qu = new LinkedList<>();
        boolean[] visited = new boolean[T+1];
        
        qu.add(1);
        memo.put(1, new Node(1));
        
        while(!qu.isEmpty()){
        	int target = qu.poll();
        	
        	if(visited[target])continue;
        	visited[target] = true;
        	
        	Node n = memo.get(target);

        	
        	for(int a : nodes.get(target)) {
        		if(visited[a])continue;
        		
        		Node temp = new Node(a); 
        		temp.parent = n;
        		memo.put(a,temp);
        		n.addChild(temp);
        		qu.add(a);
        	}
        	
        }
        for(int i = 2; i <= T; i++) {
        	if(memo.get(i).parent == null)continue;
        	bw.write(Integer.toString(memo.get(i).parent.no));
        	if(i < T)bw.write("\n");
        }
       
        bw.flush();
        bw.close();
	}
	
	
}

