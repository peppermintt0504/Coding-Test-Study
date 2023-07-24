import java.io.*;
import java.util.*;

class Solution
{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String args[]) throws Exception
	{
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			int[][] board = new int[N][N];
			
			for(int i = 0; i < N; i++) 
				board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			
			for(int i = 0 ; i < N; i++) {
				for(int z = Math.abs((int) (N / 2) - i); z < N - Math.abs((int) (N / 2) - i); z++) {
					answer += board[i][z];
				}
			}
			System.out.printf("#%d %d",t+1,answer);
			if(t != T - 1)System.out.println();
		}
		
		
	}
}