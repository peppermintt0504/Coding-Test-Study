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
			int[][] board = new int[n][n];
			
			int num = 1;
			int x = 0;
			int y = 0;
			int count = 0;
			int direction = 0;
			while(num <= Math.pow(n, 2)) {
				board[y][x] = num;
				switch (direction) {
					case 0 :{
						if(x + count == n - 1) {
							direction++;
							y++;
						}else {
							x++;
						}
						break;
					}
					
					case 1 :{
						if(y + count == n -1) {
							direction++;
							x--;
						}else {
							y++;
						}
						break;
					}
					
					case 2 :{
						if(x == count) {
							direction++;
							count++;
							y--;
						}else {
							x--;
						}
						break;
					}
					
					case 3 :{
						if(y == count) {
							direction = 0;
							x++;
						}else {
							y--;
						}
						break;
					}
				}
				
				
				num++;
			}
			
			System.out.printf("#%d\n",t+1);
			for(int i = 0 ; i < n; i++) {
				String str = "";
				for(int v : board[i]) {
					str += Integer.toString(v) + " ";
				}
				str.trim();
				System.out.printf(str);
				if(i != n)System.out.println();
			}
		}
	}
}
