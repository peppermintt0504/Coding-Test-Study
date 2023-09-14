import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;

	static int[] dx= {0,1,0,-1};
	static int[] dy= {-1,0,1,0};

	static class Pos{
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Pos() {
			// TODO Auto-generated constructor stub
		}
	}

	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[][] board = new int[N][N];
		int max = 0;
		int min = INF;
		
		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int num : board[i]) {
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
		}
		
		for(int h = min; h < max; h++) {
			int count = 1;
			
			int[][] visited = new int[N][N];
			
			for(int y = 0; y < N; y++) {
				for(int x = 0; x < N; x++) {
					if(visited[y][x] != 0 || board[y][x] <= h)continue;
					
					ArrayDeque<Pos> qu = new ArrayDeque<>();
					qu.add(new Pos(x,y));
					
					while(!qu.isEmpty()) {
						Pos cur = qu.poll();
						
						if(visited[cur.y][cur.x] != 0 || board[cur.y][cur.x] <= h)continue;
						visited[cur.y][cur.x] = count;
						
						for(int i = 0; i < 4; i++) {
							int mx = dx[i] + cur.x;
							int my = dy[i] + cur.y;
							
							if(mx >= N || mx < 0 || my >= N || my < 0 || visited[my][mx] != 0 || board[my][mx] <= h)continue;
							qu.add(new Pos(mx,my));
						}
					}
					count++;
				}
			}
//			System.out.println(count);
			answer = Math.max(answer, count);
		}
		System.out.println(answer-1 == -1 ? 1 : answer - 1);
	}
	
}
