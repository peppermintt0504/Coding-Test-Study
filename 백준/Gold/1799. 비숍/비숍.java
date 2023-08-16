import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	
	public static int[][] board;
	public static boolean[][] visited;
	public static ArrayList<Blank> Wblanks = new ArrayList<>();
	public static ArrayList<Blank> Bblanks = new ArrayList<>();
	public static Stack<Blank> stack = new Stack<>();
	public static int N;
	public static int Wanswer = 0;
	public static int Banswer = 0;
	
	public static class Blank{
		int x;
		int y;
		public Blank() {
			// TODO Auto-generated constructor stub
		}
		public Blank(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "[" + Integer.toString(this.x) + ", " + Integer.toString(this.y) + "]";
		}
	}
	
	public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j = 0 ; j < N; j++) {
				if(board[i][j] == 1)
					if((i+j) % 2 == 0) {
						Wblanks.add(new Blank(j,i));
					}else {
						Bblanks.add(new Blank(j,i));
					}
			}
		}
		Wblanks.sort((a,b)-> a.y - b.y);
		Bblanks.sort((a,b)-> a.y - b.y);


		DFS(new Blank(0,0),0,0,true);
		DFS(new Blank(0,0),0,0,false);
		System.out.println(Wanswer + Banswer);
	}
	public static void DFS(Blank bl, int count, int start , boolean isWhite) {
		
		if(isWhite) {
			if(Wanswer < count) {
				Wanswer = count;
//				System.out.println(stack.toString());
			}
		}else {
			if(Banswer < count) {
				Banswer = count;
			}
		}
		ArrayList<Blank> arr = isWhite ? Wblanks : Bblanks;
		

		for(int i = start; i < arr.size(); i++) {
			Blank b = arr.get(i);
			if(!visited[b.y][b.x] && check(b.x,b.y)) {
				visited[b.y][b.x] = true;
				board[b.y][b.x] = 9;

				DFS(b,count+1,i+1,isWhite);

				visited[b.y][b.x] = false;
				board[b.y][b.x] = 0;
			}
		}
	}
	
	
	
	public static boolean check(int x, int y) {
		boolean isPossible = true;
		
		for(int i = 0; i <= y; i++) {
			int mx = x - i;
			int my = y - i;
			
			if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
			if(board[my][mx] == 9) {
				return false;
				
			}
		}
		
		for(int i = 0; i <= y; i++) {
			int mx = x + i;
			int my = y - i;
			
			if(mx < 0 || mx >= N || my < 0 || my >= N) continue;
			if(board[my][mx] == 9) {
				return false;
			}
		}
		
		return isPossible;
	}
}	

//10
//1 1 0 1 1 1 1 0 0 1
//0 1 0 0 0 1 0 1 0 1
//1 0 1 0 1 0 1 1 1 0
//1 0 0 0 0 1 0 0 0 1
//1 0 1 1 1 0 0 0 0 0
//1 1 0 1 1 1 1 0 0 1
//0 1 0 0 0 1 0 1 0 1
//1 0 1 0 1 0 1 1 1 0
//1 0 0 0 0 1 0 0 0 1
//1 0 1 1 1 0 0 0 0 0