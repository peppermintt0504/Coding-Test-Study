import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;

	public static long standard = (long) Math.pow(10, 15);
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		

		int[][] dp = new int[n+1][m+1];

		for(int i = 0; i <= n; i++) {
			dp[i][1] = 1;
		}
		
		for(int i = 2; i <= m; i++) {
			
			for(int j = 0; j<=n;j++) {
				for(int x = 0 ; x <=n; x++) {
					if(j-x >= 0) {
						dp[j][i] = (dp[j][i] + dp[j-x][i-1])%1000000000;
					}
				}
			}
			
		}
		
		System.out.println(dp[n][m]%1000000000);
	}
}

