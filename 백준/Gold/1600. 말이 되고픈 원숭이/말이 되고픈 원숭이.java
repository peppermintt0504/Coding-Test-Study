import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;

	static int[] dx = {0,1,0,-1,-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {-1,0,1,0,-1,-2,-2,-1,1,2,2,1};

	static int C;
	static int N;
	static int M;
	static int[][] board;
	static int answer = 0;
	static int min = -1;
	
	static class Pos{
		int x;
		@Override
		public String toString() {
			return "Pos [x=" + x + ", y=" + y + ", chance=" + chance + ", distance=" + distance + "]";
		}
		int y;
		int chance;
		int distance;

		public Pos() {}
		public Pos(int x, int y, int chance,int distance) {
			this.x = x;
			this.y = y;
			this.chance = chance;
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws IOException{
		C = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		
		boolean[][][] visited = new boolean[N][M][C+1];
		
		for(int n = 0; n < N; n++) {
			board[n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		Queue<Pos> qu = new LinkedList<>();
		qu.add(new Pos(0,0,C,0));
		
		while(!qu.isEmpty()) {
			Pos cur = qu.poll();
			
			if(cur.x == M -1 && cur.y == N - 1) {
//				System.out.println(cur);
				min = cur.distance;
				break;
			}
			
			if(visited[cur.y][cur.x][cur.chance])continue;
			visited[cur.y][cur.x][cur.chance] = true;
			
			
			
			for(int i = 0; i < 12; i++) {
				if(cur.chance == 0 && i > 3)break;
				int mx = cur.x + dx[i];
				int my = cur.y + dy[i];
				int mCount = (i > 3) ? cur.chance - 1 : cur.chance;
				if(mx < 0 || mx >= M || my < 0 || my >= N || board[my][mx] == 1 || visited[my][mx][mCount])continue;
				
				qu.add(new Pos(mx,my,mCount,cur.distance+1));
			}
			
			
		}
		
		System.out.println(min);
	}
	
	
	
	public static void DFS(boolean[][][] visited, int x, int y, int count, int move) {
		

		System.out.println(x + " " + y + " " + count + " " + move);
		if(x == M - 1 && y == N - 1) {
			
			if(min == move) {
				answer++;
			}else if(min > move) {
				answer = 1;
				min = move;
			}
			return;
		}
		
		
		for(int i = 0; i < 12; i++) {
			if(count == 0 && i > 3)break;
			int mx = x + dx[i];
			int my = y + dy[i];
			int mCount = (i > 3) ? count - 1 : count;
			if(mx < 0 || mx >= M || my < 0 || my >= N || board[my][mx] == 1 || visited[my][mx][mCount])continue;
			
			for(int z = 0; z <= mCount;z++) {
				visited[my][mx][z] = true;
			}
			DFS(visited,mx,my,mCount,move+1);
			for(int z = 0; z <= mCount;z++) {
				visited[my][mx][z] = false;
			}
		}
		
	}
}