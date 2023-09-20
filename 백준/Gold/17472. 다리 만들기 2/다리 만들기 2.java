import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	
	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	static class Route implements Comparable<Route>{
		
		int to;
		int cost;

		public Route() {}
		public Route(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Route o) {
			return this.cost - o.cost;
		}
		@Override
		public String toString() {
			return "Route [to=" + to + ", cost=" + cost + "]";
		}
		
	}
	
	static class Pos{
		int x;
		int y;
		
		public Pos() {}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N][M];
		
		for(int i = 0; i < N; i ++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[][] visited = new int[N][M];
		int count = 1;
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < M; x++) {
				if(board[y][x] == 0 || visited[y][x] != 0 )continue;
				
				ArrayDeque<Pos> dq = new ArrayDeque<>();
				
				dq.add(new Pos(x,y));
				
				while(!dq.isEmpty()) {
					Pos cur = dq.poll();
					
					if(visited[cur.y][cur.x] != 0)continue;
					visited[cur.y][cur.x] = count;
					
					for(int i = 0 ; i < 4 ; i++) {
						int mx = dx[i] + cur.x;
						int my = dy[i] + cur.y;
						
						if(mx >= M|| mx < 0 || my >= N || my < 0 || visited[my][mx] != 0 || board[my][mx] == 0)continue; 
						
						dq.add(new Pos(mx,my));
					}
				}
				
				count++;
			}
		}
		
//		for(int[] a : visited)System.out.println(Arrays.toString(a));
		
		int[][] distance = new int[count][count];
		for(int i = 0 ; i < count; i++) {
			Arrays.fill(distance[i], INF);
			distance[i][i] = 0;
		}
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < M; x++) {
				if(visited[y][x] == 0)continue;
				
				int cur = visited[y][x];
				
				for(int i = 0 ; i < 4; i++) {
					int mx = x;
					int my = y;
					int dist = 0;
					while(true) {
						mx += dx[i];
						my += dy[i];
						dist++;
						if(mx >= M || mx < 0 || my >= N || my < 0 || visited[my][mx] == cur) break;
						if(visited[my][mx] != 0) {
							if(dist -1 > 1)
								distance[cur][visited[my][mx]] = Math.min(distance[cur][visited[my][mx]], dist-1);
							break;
						}
					}
				}
				
			}
		}
		
//		for(int i = 0; i <count; i++) {
//			for(int j =0 ;j < count; j++) {
//				if(distance[i][j] == INF) distance[i][j] = 0;
//			}
//		}
//		for(int[] d : distance)
//			System.out.println(Arrays.toString(d));
		
		for(int i = 1 ; i < count; i++) {
			int cnt = Arrays.stream(distance[i]).reduce(0, (x,v)-> v > 1 && v <INF ? x+1:x);
//			System.out.println(cnt);
			if(cnt < 1) {
				System.out.println(-1);
				return;
			}
		}
		
		PriorityQueue<Route> pq = new PriorityQueue<>();
		boolean[] vi = new boolean[count];
		int answer = 0;
		int check = 0;
		pq.add(new Route(1,0));
		
		
		while(!pq.isEmpty()) {
			Route cur = pq.poll();
			
			if(vi[cur.to])continue;
			vi[cur.to] = true;
			answer+= cur.cost;
			check++;
			for(int x = 1; x < count;x++) {
				if(x == cur.to || vi[x] || distance[cur.to][x] <= 1 || distance[cur.to][x] ==INF)continue;
				
				pq.add(new Route(x,distance[cur.to][x]));
			}
			
		}
//		System.out.println(count + " " + check);
		System.out.println(answer == 0 || check != count-1 ? -1 : answer);
		
	}
}


