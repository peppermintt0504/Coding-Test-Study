import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	
	static class Network implements Comparable<Network>{
		int to;
		int cost;
		
		public Network() {}
		public Network(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Network o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Network [to=" + to + ", cost=" + cost + "]";
		}
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N+1][N+1];
		for(int n = 1; n<=N;n++) {
			Arrays.fill(board[n], INF);
			board[n][n] = 0;
		}
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			board[a][b] = cost;
			board[b][a] = cost;
			
		}
		
		PriorityQueue<Network> qu = new PriorityQueue<>();
		
		qu.add(new Network(1,0));
		long answer =0;
		boolean[] visited= new boolean[N+1];
		
		while(!qu.isEmpty()) {
			Network cur = qu.poll();
			
			
			
			if(visited[cur.to])continue;
			visited[cur.to] = true;
			
//			System.out.println(cur);
			
			answer += cur.cost;
			
			for(int i = 1; i <= N; i++) {
				if(i == cur.to)continue;
				
				qu.add(new Network(i,board[cur.to][i]));
				
			}
			
		}
		System.out.println(answer);
	}
	
}