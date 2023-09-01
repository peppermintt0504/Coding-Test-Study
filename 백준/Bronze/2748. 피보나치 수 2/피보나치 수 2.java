import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;

	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static int N;
	public static int M;
	public static int answer = 0;
	public static int[][] board;
	public static int[][] dp;
	public static class Pos{
		int x;
		int y;
		int height;

		public Pos() {}
		public Pos(int x, int y, int height) {
			this.x = x;
			this.y = y;
			this.height= height;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int A = Integer.parseInt(br.readLine());
		
		long[] dp = new long[Math.max(A+1,2)];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= A; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[A]);
	}
}

