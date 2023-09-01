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
		
		int[] coins = new int[n];
		int[] dp = new int[m+1];
		Arrays.fill(dp, INF);
		for(int i = 0; i <n ; i++)	coins[i] = Integer.parseInt(br.readLine());

		dp[0] = 0;
		for(int i = 1; i <= m; i++) {
			for(int j = 0; j < n; j++) {
				if(i - coins[j] >= 0 && dp[i-coins[j]] != INF) {
					dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
		}
		System.out.println(dp[m] == INF ? -1 : dp[m]);
		
	}
}

