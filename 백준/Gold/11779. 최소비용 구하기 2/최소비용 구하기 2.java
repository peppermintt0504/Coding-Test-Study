import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int INF = 1_000_000_000;
	public static ArrayList<HashMap<Integer,Node>> route = new ArrayList<>();
	public static Node[] memo;
	public static class Node implements Comparable<Node>{
		
		int next;
		int cost;
		ArrayList<Integer> r;
		public Node() {}

		public Node(int next, int cost) {
			super();
			this.next = next;
			this.cost = cost;
			this.r = new ArrayList<>();
		}

		public void setRoute(ArrayList<Integer> r) {
			this.r = r;
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", cost=" + cost + ", r=" + r + "]";
		}
		
	}
	
	public static int N;
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int size = N;
		memo = new Node[N+1];
		for(int i = 0 ; i <= N; i++) {
			route.add(new HashMap<>());
			memo[i] = new Node(i,0);
		}
		
		
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] temp = djikstra(start);

			
		System.out.println(temp[end]);
		System.out.println(memo[end].r.size()+1);
		System.out.print(Integer.toString(start) + " ");
		for(int i = 0; i < memo[end].r.size();i++) {
			System.out.print(memo[end].r.get(i));
			if(i < memo[end].r.size() - 1) System.out.print(" ");
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
		
		Node first = new Node(start,0);
		
		qu.add(first);
		
		while(!qu.isEmpty()) {
			Node cur = qu.poll();
			if(visited[cur.next])continue;
			visited[cur.next] = true;
			for(int no : route.get(cur.next).keySet()) {
				Node nextNode = route.get(cur.next).get(no);
				if(dp[nextNode.next] >= dp[cur.next] + nextNode.cost) {
					dp[nextNode.next] = dp[cur.next] + nextNode.cost;
					Node temp =new Node(nextNode .next,dp[nextNode.next]);
					ArrayList<Integer> tempArr = (ArrayList<Integer>) cur.r.clone();
					tempArr.add(nextNode.next);
					temp.setRoute(tempArr);
					memo[nextNode.next] = temp;
					qu.add(temp);
				}
			}
		}
		
		
		return dp;
	}
}