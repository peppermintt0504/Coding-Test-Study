import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static int[][] row =  {{1,0,1},{1,1,3}};
	public static int[][] col =  {{0,1,2},{1,1,3}};
	public static int[][] cro =  {{1,0,1},{0,1,2},{1,1,3}};
	public static int[][][]move = {{},row,col,cro};
	
	public static int[][][] rowRoute = {{{1,0}}, {{1,0},{0,1},{1,1}}};
	public static int[][][] colRoute = {{{0,1}}, {{1,0},{0,1},{1,1}}};
	public static int[][][] croRoute = {{{1,0}}, {{0,1}}, {{1,0},{0,1},{1,1}}};
	public static int[][][][] moveRoute = {{},rowRoute,colRoute,croRoute};
	
	public static int[][] board;
	public static int N;
	public static int count = 0;
	
	public static class Pos {
		int x;
		int y;
		int count;
		int direction;
		
		public Pos() {}
		
		public Pos(int x, int y ,int direction,int count) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.direction = direction;
		}
		@Override
		public String toString() {
			return "[" + Integer.toString(x) + ", " + Integer.toString(y) + "] = " + Integer.toString(count);
		}
	}
	
	public static void main(String[] args) throws IOException{
       N = Integer.parseInt(br.readLine());
       
       board = new int[N][N];
       
       for(int i = 0; i < N; i++) {
    	   board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
       }
       
       
       
       
       Pos start = new Pos(1,0,1,0);
       
       DFS(start);
       
       System.out.println(count);
	}
	
	public static void DFS(Pos cur) {
		if(cur.x == N - 1 && cur.y == N -1) {
			count++;
		}
		
		
		for(int i = 0; i < move[cur.direction].length; i++) {
 		   int mx = cur.x + move[cur.direction][i][0];
 		   int my = cur.y + move[cur.direction][i][1];
 		   
 		   if(mx >= N || my >= N || board[my][mx] != 0) continue;
 		   if(move[cur.direction][i][2] == 3) 
 			   if(board[my-1][mx] != 0 || board[my][mx-1] != 0) continue;
 		   DFS(new Pos(mx,my,move[cur.direction][i][2],cur.count + 1));
 	   }
	}
}

