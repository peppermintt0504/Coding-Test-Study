import java.io.*;
import java.util.*;

 
 
public class Main {
	
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		
		if(N == 1) {
			bw.write("1");
		}else if(N == 2) {
			bw.write("2");
		}else {
			
			dp[1] = 1;
			dp[2] = 2;
			
			for(int i = 3; i <=N; i++) {
				dp[i] = (dp[i-1]+dp[i-2]) % 10007;
			}
			bw.write(Integer.toString(dp[N]%10007));
		}
		

		bw.flush();
		bw.close();
		
	}
}