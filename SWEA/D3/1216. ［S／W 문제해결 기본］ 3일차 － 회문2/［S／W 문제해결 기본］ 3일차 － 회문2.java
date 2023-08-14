import java.util.*;
import java.io.*;


public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static void main(String[] args) throws IOException{
		int T = 10;
//		String[] temp1 = "1234567890".split("");
//		
//		
//		System.out.println(Arrays.toString(Arrays.copyOfRange(temp1, 10, 10)));
		
		while(T --> 0) {
			int num = Integer.parseInt(br.readLine());
			int size = 0;
			String[][] board = new String[100][100];
			
			for(int i = 0 ; i < 100; i++) {
				board[i] = br.readLine().split("");
				
			}
			
			
			

			for(int y = 0; y < 100; y++) {
				for(int s = 0; s < 100; s++) {
					for(int j = s; j <= 100; j++) {
						String[] temp = Arrays.copyOfRange(board[y], s, j);
						if(isPen(temp)) {
							size = Math.max(size,temp.length);
						}
					}
				}
			}
			
			for(int x = 0; x < 100; x++) {
				for(int s = 0; s < 100; s++) {
					for(int j = s; j < 100; j++) {
						String temp = "";
						for(int i = s; i <=j; i++) {
							temp+=board[i][x];
						}
						if(isPen(temp.split(""))) {
							size = Math.max(size,temp.length());
						}
					}
				}
			}
			
			bw.write("#" + Integer.toString(num) + " "+Integer.toString(size));
			if(num < 10)bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}
	
	public static boolean isPen(String[] str) {
		boolean answer = true;
		for(int i = 0; i < str.length/2 ; i++) {
			if(!str[i].equals(str[str.length - 1 - i])) {
				return false;
			}
		}

		return answer;
	}
}
