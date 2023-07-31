import java.util.*;
import java.io.*;
public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static String[][] board;
	public static int[] visited = new int[26];
	public static int R;
	public static int C;
	public static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new String[R][C];
		
		for(int i = 0; i < R; i++) {
			board[i] = br.readLine().split("");
		}
		
		
		visited[(int) board[0][0].charAt(0)-(int) 'A'] = 1;
		DFS(0,0,1);
		visited[(int) board[0][0].charAt(0)-(int) 'A'] = 0;
		
		
		System.out.println(max);
	}

	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static void DFS(int x,int y, int count) {
		
		for(int i = 0; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			
			if(mx < 0 || mx >= C || my < 0 || my >= R)	continue;
			if(visited[board[my][mx].charAt(0)-(int) 'A'] == 0) {
//				System.out.printf("[%d,%d] = %s -> %d\n",my,mx,board[my][mx],count+1);
				visited[board[my][mx].charAt(0)-(int) 'A'] = 1;
				DFS(mx,my,count+1);
				visited[board[my][mx].charAt(0)-(int) 'A'] = 0;
			}
			
			if(max < count)max = count;
		}
	}
}
