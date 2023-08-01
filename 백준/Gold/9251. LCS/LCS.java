import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	
	public static void main(String[] args) throws IOException{
		int answer = 0;
		int[] visited = new int[26];
		int[] visited2 = new int[26];
		
		String A = br.readLine();
		String B = br.readLine();
		
		int[][] dp = new int[A.length()+1][B.length()+1];
		
		for(int i = 1; i <= A.length(); i++) {
			for(int j = 1; j <= B.length();j++) {
				if(A.charAt(i-1) == B.charAt(j-1)) 	dp[i][j] = dp[i-1][j-1] + 1;
				else							dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				
			}
		}
		
		System.out.println(dp[A.length()][B.length()]);

	}
}


