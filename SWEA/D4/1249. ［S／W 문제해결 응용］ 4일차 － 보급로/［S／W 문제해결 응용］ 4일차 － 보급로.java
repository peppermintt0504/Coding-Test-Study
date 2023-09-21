import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
 
public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 1_000_000;

	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		int distance;
		
		public Pos() {}
		public Pos(int x, int y, int distance) {
			this.x= x;
			this.y = y;
			this.distance = distance;
		}
		@Override
		public int compareTo(Pos o) {
			
			return this.distance - o.distance;
		}
	}

	static int[] dx = {0,1,0,-1};
	static int[] dy = {-1,0,1,0};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ;t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] board = new int[N][N];
			int[][] dp = new int[N][N];
			
			
			
			for(int i = 0; i < N; i++) {
				board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dp[i], INF);
			}
			
			PriorityQueue<Pos> pq = new PriorityQueue<>();

			
			pq.add(new Pos(0,0,0));
			
			while(!pq.isEmpty()) {
				Pos cur = pq.poll();
				
				if(dp[cur.y][cur.x] <= cur.distance)continue;
				dp[cur.y][cur.x] = cur.distance;
				
				for(int i = 0 ; i < 4; i++) {
					int mx = dx[i] + cur.x;
					int my = dy[i] + cur.y;
//					System.out.println(mx + " " + my);
					if(mx >= N || my >= N || mx < 0 || my < 0 || dp[my][mx] <= cur.distance + board[my][mx])continue;
					
					pq.add(new Pos(mx,my,cur.distance + board[my][mx]));
				}
				
			}
//			for(int i = 0 ; i < N ; i++)
//				System.out.println(Arrays.toString(dp[i]));
			System.out.print("#" + t + " " + dp[N-1][N-1]);
			if(t != T)System.out.println();
		}
	}

	
}