import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N+1][M];
		int[][] dp = new int[N+1][M];
		
		for(int i = 1; i <= N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		

		
		for(int i = 1; i <= N; i++) {
			dp[i][0] = dp[i-1][0] + board[i][0];
			for(int j = 1; j < M; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + board[i][j];
			}
		}
		

		
		System.out.println(dp[N][M-1]);
	}
	
}
