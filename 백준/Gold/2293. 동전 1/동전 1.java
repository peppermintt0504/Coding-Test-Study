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
		
		for(int i = 0; i <n ; i++)	{
			coins[i] = Integer.parseInt(br.readLine());
			
		}
		dp[0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = coins[i]; j <= m; j++) {
				dp[j] += dp[j- coins[i]];
			}
			
		}
		System.out.println(dp[m]);
		
	}
}

