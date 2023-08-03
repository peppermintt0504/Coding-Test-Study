import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int INF = 10_000_000;
	public static ArrayList<HashMap<Integer,Node>> route = new ArrayList<>();
	public static class Node implements Comparable<Node>{
		
		int next;
		int cost;
		
		public Node() {}

		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
	public static int N;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int size = N;
		for(int i = 0 ; i <= N; i++)
			route.add(new HashMap<>());
		
		while(T-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(route.get(a).containsKey(b)) {
				Node temp = route.get(a).get(b);
				if(temp.cost > c) temp.cost = c;
			}else {
				Node temp = new Node(b,c);
				route.get(a).put(b, temp);
			}
		}
		for(int i = 1; i <= N; i++) {
			int[] temp = djikstra(i);
			for(int j = 1 ; j <= N;j++) {
				bw.write(Integer.toString(temp[j] == INF ? 0 : temp[j]));
				if(j != N)bw.write(" ");
			}
			if(i != route.size())bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
	public static int[] djikstra(int start) {
		int[] dp = new int[N+1]; 
		boolean[] visited = new boolean[N+1];
		PriorityQueue<Node> qu = new PriorityQueue<>();
		Arrays.fill(dp,INF);
		dp[start] = 0;
		
		qu.add(new Node(start,0));
		
		while(!qu.isEmpty()) {
			Node cur = qu.poll();
			if(visited[cur.next])continue;
			visited[cur.next] = true;
			for(int no : route.get(cur.next).keySet()) {
				Node nextNode = route.get(cur.next).get(no);
				if(dp[nextNode.next] > dp[cur.next] + nextNode.cost) {
					dp[nextNode.next] = dp[cur.next] + nextNode.cost;
					qu.add(new Node(nextNode .next,dp[nextNode.next]));
				}
			}
		}
		
		
		return dp;
	}
}