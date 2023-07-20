import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static long[] dp;
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int num = Integer.parseInt(br.readLine());
			
			dp = new long[Math.max(6, num+1)];
			
			dp[1] = 1; 
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			
			for(int i = 6 ; i <= num; i++) {
				dp[i] = dp[i-1] + dp[i-5];
			}
			bw.write(dp[num]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
}