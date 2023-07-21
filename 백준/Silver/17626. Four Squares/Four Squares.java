import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] dp = new int[50001];
	public static int[] dp2;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int num = Integer.parseInt(st.nextToken());
		
		dp[1] = 1;
		
		for(int i = 2; i <= num; i++) {
			int min = Integer.MAX_VALUE;
			
			 for (int j = 1; j * j <= i; j++) {
	                int temp = i - j * j;
	                min = Math.min(min, dp[temp]);
	            }
			
			dp[i] = min + 1;
		}
		

		System.out.println(dp[num]);
		bw.flush();
		bw.close();
	}
}
