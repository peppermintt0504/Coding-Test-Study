import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;

	public static long standard = (long) Math.pow(10, 15);
	
	public static void main(String[] args) throws IOException {
		int A = Integer.parseInt(br.readLine());
		
		BigInteger[] dp = new BigInteger[Math.max(A+1,2)];

		dp[0] = BigInteger.ZERO;
		dp[1] = BigInteger.ONE;
		
		for (int i = 2; i <= A; i++) {
			dp[i] = dp[i - 2].add(dp[i - 1]);
		}

		System.out.println(dp[A]);
	}
}

