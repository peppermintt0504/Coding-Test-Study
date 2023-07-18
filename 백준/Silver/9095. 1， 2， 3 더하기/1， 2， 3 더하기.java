import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

 
 
public class Main {
	public static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int testCase = 0; testCase < N; testCase++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 3) {
				System.out.printf("%d\n",4);
				continue;
			}
			else if(num == 2) {
				System.out.printf("%d\n",2);
				continue;
			}
			else if(num == 1) {
				System.out.printf("%d\n",1);
				continue;
			}
			dp = new int[num+1];
			
			dp[1] = 1;
			dp[2] = 2;
			dp[3] = 4;
			
			for(int i = 4; i <=num; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			System.out.printf("%d\n",dp[num]);
		}
	}
}