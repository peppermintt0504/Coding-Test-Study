import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static String[] str;
	public static void main(String[] args) throws IOException{

		str =br.readLine().split("");
	
		int[] dp = new int[str.length+1];
		Arrays.fill(dp, INF);
		dp[0] = 0;
		for(int i = 1; i <= str.length; i++) {
			for(int j = 1; j <= i;j++) {
//				System.out.printf("%d, %d -> %s\n",i,j,Boolean.toString(isPenlindrom(i-1, j-1)));
				if(isPenlindrom(j-1,i-1)) {
					dp[i]=Math.min(dp[i],dp[j-1]+1);
				}
			}
		}
		System.out.println(dp[str.length]);
	}
	public static boolean isPenlindrom(int start, int end) {
		boolean isPen = true;
		if((end - start + 1) % 2 == 0) {
			for(int i = 0; i <  (end - start + 1) / 2; i++) {
				if(!str[start + i].equals(str[end-i])) {
					return false;
				}
			}
		}else {
			for(int i = 0; i <  (end - start) / 2; i++) {
				if(!str[start + i].equals(str[end-i])) {
					return false;
				}
			}
		}
		return true;
	}
}
