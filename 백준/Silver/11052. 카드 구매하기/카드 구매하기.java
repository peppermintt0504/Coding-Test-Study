import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException{

		int N = Integer.parseInt(br.readLine());
		
		int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] dp = new int[N+1];
		
		for(int i = 1 ; i <= N; i++) {
			for(int x = 0; x < cards.length; x++) {
				if(i - 1 - x < 0)break;
				if(dp[i] < dp[i - 1 - x] + cards[x]) dp[i] =  dp[i - 1 - x] + cards[x];
			}
		}
		System.out.println(dp[N]);
	}
	
}
