import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static int V;
	public static int E;
	public static Map<Integer,ArrayList<Node>> nodes = new HashMap<>();
	public static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static class Node implements Comparable<Node>{

		int to;
		int val;
		
		public Node() {}

		public Node(int to,int val) {
			this.to = to;
			this.val = val;
		}
		@Override
		public int compareTo(Node o) {
			return (this.val - o.val);
		}

	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		while(E --> 0) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int val = Integer.parseInt(st.nextToken());
			
			
			
			if(!nodes.containsKey(n1)) 
				nodes.put(n1, new ArrayList<>());
			nodes.get(n1).add(new Node(n2,val));
			
			if(!nodes.containsKey(n2)) 
				nodes.put(n2, new ArrayList<>());
			nodes.get(n2).add(new Node(n1,val));
			

		}
		
		boolean[] visited = new boolean[V+1];
		int answer = 0;
		
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			answer+=cur.val;
			
			for(Node n : nodes.get(cur.to)) {
				if(!visited[n.to])
					pq.add(n);
			}
		}
		System.out.println(answer);
	}
}