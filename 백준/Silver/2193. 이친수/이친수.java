import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		
		long[] dp = new long[T+1];
		
		if(T < 3) {
			System.out.println(1);
			return;
		}
		dp[1] = 1;
		dp[2] = 1;
		for(int i = 3; i <= T; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[T]);
	}
	
}