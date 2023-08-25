import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());

		for(int t = 1 ; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			StringBuilder sb = new StringBuilder();
			
			int answer = 0;
			int[][] board = new int[N][3];
			
			for(int y = 0; y < N ; y++) {
				String[] temp = br.readLine().split("");
				
				for(int i = 0; i < temp.length; i++) {
					if(temp[i].equals("W")) board[y][0]++;
					else if(temp[i].equals("B")) board[y][1]++;
					else board[y][2]++;
				}
			}
			
			
			int min = Integer.MAX_VALUE;
			for(int i = 1; i < N-1; i++) {
				for(int j = i;j < N-1; j++) {
					
					int result = 0;
					for(int x = 1; x < i;x++) {
						result+=M - board[x][0];
					}
					
					for(int x = i; x <= j;x++) {
						result+=M - board[x][1];
					}
					
					for(int x = j+1; x < N-1;x++) {
						result+=M - board[x][2];
					}
					
					min = Math.min(min, result);
				}
			}
			
			sb.append(min+(2*M-board[0][0]-board[N-1][2]));
			
			System.out.printf("#%d %s\n",t,sb.toString().trim());
		}
	}
	
}