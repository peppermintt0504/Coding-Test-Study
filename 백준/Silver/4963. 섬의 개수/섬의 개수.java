import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	
	static int[] dx = {0,1,0,-1,-1,1,1,-1};
	static int[] dy = {-1,0,1,0,-1,-1,1,1};

	public static class Pos{
		int x;
		int y;
		
		public Pos() {}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException{
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0)break;
			
			int[][] board = new int[h][w];
			int[][] visited = new int[h][w];
			ArrayDeque<Pos> dq = new ArrayDeque<>();
			
			int count = 1;
			
			for(int i = 0; i < h; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int y=0; y < h; y++) {
				for(int x = 0 ;  x < w; x++) {
					if(visited[y][x] != 0 || board[y][x] == 0)continue;
					
					dq.add(new Pos(x,y));
					
					while(!dq.isEmpty()) {
						Pos cur = dq.poll();
						
						if(visited[cur.y][cur.x] != 0)continue;
						visited[cur.y][cur.x] = count;
						
						for(int i = 0 ; i < 8; i++) {
							int mx = dx[i] + cur.x;
							int my = dy[i] + cur.y;
							
							if(mx >= w || mx < 0 || my >= h || my < 0 || visited[my][mx] != 0 || board[my][mx] == 0)continue;
							
							dq.add(new Pos(mx,my));
						}
					}
					
					count++;
				}
			}
			
//			for(int i = 0; i < h ; i++)System.out.println(Arrays.toString(visited[i]));
			System.out.println(count-1);
		}
		
		
		
	}
	
	
}

