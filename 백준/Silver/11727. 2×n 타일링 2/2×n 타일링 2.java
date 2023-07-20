import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		dp = new int[T+1];
		
		if(T == 1) {
			bw.write("1");
		}else if(T == 2) {
			bw.write("3");
		}else {
			dp[1] = 1;
			dp[2] = 3;
			
			for(int i = 3; i <= T; i++) {
				dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
			}
			bw.write(Integer.toString(dp[T] % 10007));
		}
		bw.flush();
		bw.close();
	}
}