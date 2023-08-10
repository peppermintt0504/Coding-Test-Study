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
			int n = Integer.parseInt(br.readLine());
			String[][] board = new String[n][n];
			
			boolean iswin = false;
			
			
			for(int i = 0 ; i < n; i++) {
				board[i] = br.readLine().split("");
			}
			
			for(int x = 0 ; x < n; x++) {
				if(iswin)break;
				for(int y = 0 ; y <= n - 5;y++) {
					
					int count = 0;
					
					for(int z = 0; z < 5; z++) {
						if(board[x][y + z].equals("o")) {
							count++;
						}
						else {
							break;
						}
					}
					if(count == 5) {
						iswin=true;
						break;
					}
				}
			}
			
			
			for(int x = 0 ; x < n; x++) {
				if(iswin)break;
				for(int y = 0 ; y <= n - 5;y++) {
					
					int count = 0;
					
					for(int z = 0; z < 5; z++) {
						if(board[y + z][x].equals("o")) {
							count++;
						}
						else {
							break;
						}
					}
					if(count == 5) {
						iswin=true;
						break;
					}
				}
			}
			
			for(int x = 0 ; x <= n - 5; x++) {
				if(iswin)break;
				for(int y = 0 ; y <= n - 5;y++) {
					int count = 0;
					
					for(int z = 0; z < 5; z++) {
						if(board[y+z][x+z].equals("o")) {
							count++;
						}
						else {
							break;
						}
					}
					if(count == 5) {
						iswin=true;
						break;
					}
				}
			}
			
			for(int x = 0 ; x <= n - 5; x++) {
				if(iswin)break;
				for(int y = 0 ; y <= n - 5;y++) {
					int count = 0;
					
					for(int z = 0; z < 5; z++) {
						if(board[y+z][n-1-(x+z)].equals("o")) {
							count++;
						}
						else {
							break;
						}
					}
					if(count == 5) {
						iswin=true;
						break;
					}
				}
			}
			
			
			if(iswin) {
				System.out.printf("#%d YES\n",t+1);
			}else {
				System.out.printf("#%d NO\n",t+1);
			}
		}
	}
}
