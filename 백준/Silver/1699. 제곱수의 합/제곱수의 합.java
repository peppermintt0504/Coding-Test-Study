import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException{

		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2 ; i <= N; i++) {
			for(int x = 1; x*x <= i;x++) {
				if(dp[i] > dp[i - x*x]+1) {
					dp[i] = dp[i - x*x]+1;
				}
			}
		}
		System.out.println(dp[N]);
	}
	
}
