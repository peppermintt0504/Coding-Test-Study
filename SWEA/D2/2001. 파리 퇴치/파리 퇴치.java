import java.util.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int max = 0;
			int[][] board = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int i = 0 ; i <= n-m; i++) {
				for(int j = 0; j <= n - m; j++) {
					int result = 0;
					
					for(int x = 0; x < m;x++) {
						for(int y = 0 ; y < m; y++) {
							result += board[i+x][j+y];
						}
					}
					max = Math.max(max, result);
				}
			}
			
			
			
			
			
			System.out.printf("#%d %d",t+1,max);
			if(t != T)System.out.println();
		}
	}
}
