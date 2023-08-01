import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int[][] board;
	public static Queue<Point> qu = new LinkedList<>();
	public static Queue<Point> tempQu = new LinkedList<>();
	
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	
	public static int N;
	public static int M;
	
	public static class Point {
		
		int x;
		int y;
		int answer;
		
		public Point() {}

		public Point(int x, int y, int answer) {
			super();
			this.x = x;
			this.y = y;
			this.answer = answer;
		}
		
		public boolean isOut() {
			int count = 0;
			
			for(int i = 0 ; i < 4; i++) {
				int mx = this.x + dx[i];
				int my = this.y + dy[i];
				
				if(mx < 0 || mx >= M || my < 0|| my >= N) continue;
				
				if(board[my][mx] == 8)count++; 
//				System.out.printf("board[%d][%d] = %d ---> %d\n",my,mx,board[my][mx],count);
			}
			
			return count >= 2;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", answer=" + answer + "]";
		}
	}
	
	public static void main(String[] args) throws IOException{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = 0;
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
		
			board = new int[N][M];
			
			for(int i = 0 ; i < N; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
				for(int x = 0; x < M; x++) {
					if(board[i][x] == 1)
						qu.add(new Point(x,i,1));
				}
			}
			
			
			tempQu.add(new Point(0,0,0));
			
			while(!qu.isEmpty()) {
				Point tar = qu.poll();
				
				if(time != tar.answer) {
					while(!tempQu.isEmpty()) {
						Point delPoint = tempQu.poll();
						checkBoard(delPoint.x,delPoint.y);
					}
					
					time = tar.answer;
					
				}
				if(!tar.isOut()) {
					qu.add(new Point(tar.x,tar.y,tar.answer+1));
				}else {
					tempQu.add(new Point(tar.x,tar.y,tar.answer+1));
				}
			}
			
//			for(int[] t : board) {
//				System.out.println(Arrays.toString(t));
//			}System.out.println();
			System.out.println(time);
	}
	
	public static void checkBoard(int x,int y) {
		board[y][x] = 8;
		Queue<Point> tq = new LinkedList<>();
		
		tq.add(new Point(x,y,8));
		
		while(!tq.isEmpty()) {
			Point delPoint = tq.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int mx = delPoint.x + dx[i];
				int my = delPoint.y + dy[i];
				
				if(mx < 0 || mx >= M || my < 0|| my >= N) continue;
				
				if(board[my][mx] == 0) { 
					board[my][mx] = 8;
					tq.add(new Point(mx,my,8));
				}
				
			}
		}
		
	}
}


