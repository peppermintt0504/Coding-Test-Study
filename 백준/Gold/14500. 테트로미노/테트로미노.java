import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[][] board;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int answer = 0;
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		board = new int[m][n];
		
		for(int i = 0; i < m;i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int[] dx1 = {1,0,0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 1};
		int[] dx2 = {2,0,0, 0, 2, 2, 1, 0, 1, 1, 0, 1,-1, 1, 1, 1, 1, 1, 1};
		int[] dx3 = {3,0,1,-1, 2, 2, 1, 0, 2, 2, 1, 1,-1, 2, 2, 2, 0, 2, 1};
		
		int[] dy1 = {0,1,1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0,-1};
		int[] dy2 = {0,2,2, 2, 0, 0, 1, 1, 1, 0, 1, 1, 1,-1, 1, 1, 1,-1, 0};
		int[] dy3 = {0,3,2, 2, 1,-1, 2, 2, 1, 0, 1, 2, 2,-1, 1, 0, 2, 0, 1};
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				
				for(int d = 0; d <19; d++) {
					
					int x1 = j + dx1[d];
					int y1 = i + dy1[d];
					int x2 = j + dx2[d];
					int y2 = i + dy2[d];
					int x3 = j + dx3[d];
					int y3 = i + dy3[d];
					
					if(x1 < 0 || x2 < 0 || x3 < 0 || y1 < 0 || y2 < 0 || y3 < 0 ||
					   x1 >= n || x2 >= n || x3 >= n || y1 >= m || y2 >= m || y3 >= m) continue;
					int sum = board[i][j] + board[y1][x1] + board[y2][x2] + board[y3][x3];
					if(answer < sum) answer = sum;
				}
			}
		}
		System.out.printf("%d",answer);
		bw.flush();
		bw.close();
	}
}