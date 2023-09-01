import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;

	public static class Route{
		int val;
		ArrayList<Integer> list = new ArrayList<>();
		public Route() {}
		public Route(int val) {
			this.val = val;
		}
	}
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] dp = new int[N];
		Route[] dp2 = new Route[N];
		int max = 0;
		int maxIndex = 0;
		for(int i = 0 ; i < N; i++) {
			dp[i] = 1;
			dp2[i] = new Route(1);
			for(int j = 0; j <= i; j++) {
				if(nums[i] > nums[j] && dp[i] < dp[j]+1) {
						dp[i] = dp[j]+1;
						dp2[i].list = (ArrayList<Integer>) dp2[j].list.clone();
						
						if(max < dp[i]) {
							max = dp[i];
							maxIndex = i;
						}
				}
			}
			dp2[i].list.add(nums[i]);
		}
		System.out.println(dp[maxIndex]);
		
		StringBuilder sb = new StringBuilder();
		for(int n : dp2[maxIndex].list) {
			sb.append(" " + n);
		}
		System.out.println(sb.toString().trim());
	}
}

