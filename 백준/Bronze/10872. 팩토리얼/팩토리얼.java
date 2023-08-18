import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static Long INF = Long.MAX_VALUE;

	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		if(N == 0) {
			System.out.println(1);
			return;
		}
		
		int[] dp = new int[N+1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2 ; i <= N; i++) {
			dp[i] = dp[i-1] * i;
		}
		System.out.println(dp[N]);
	}
}	


