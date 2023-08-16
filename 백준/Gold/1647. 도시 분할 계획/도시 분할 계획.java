import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	
	public static Map<Integer,ArrayList<Node>> memo = new HashMap<>();
	
	public static class Node implements Comparable<Node>{
		int to;
		int cost;
		
		public Node() {
			
		}
		
		public Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "[to : "+Integer.toString(this.to) + ", cost : " + Integer.toString(this.cost) +"]";
		}
	}

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			if(memo.containsKey(a)) {
				memo.get(a).add(new Node(b,cost));
			}else {
				ArrayList<Node> temp = new ArrayList<>();
				temp.add(new Node(b,cost));
				memo.put(a, temp);
			}
			
			if(memo.containsKey(b)) {
				memo.get(b).add(new Node(a,cost));
			}else {
				ArrayList<Node> temp = new ArrayList<>();
				temp.add(new Node(a,cost));
				memo.put(b, temp);
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int answer = 0;
		int max = 0;
		pq.add(new Node(1,0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(visited[cur.to])continue;
			visited[cur.to] = true;
			
			answer += cur.cost;
			max = Math.max(cur.cost, max);
			
			for(Node next : memo.get(cur.to)) {
				if(!visited[next.to]) {
					pq.add(new Node(next.to,next.cost));
				}
			}
		}
		
		System.out.println(answer - max);
	}
	
}	
