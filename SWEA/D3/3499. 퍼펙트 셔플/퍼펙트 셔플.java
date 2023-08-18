import java.util.*;
import java.util.stream.*;
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
		int T = Integer.parseInt(br.readLine());
//		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			
			String[] strs = br.readLine().split(" ");
			
			String[] temp1 = Arrays.copyOfRange(strs, 0, N%2 == 0 ? N/2 : (N+1)/2);
			String[] temp2 = Arrays.copyOfRange(strs, N%2 == 0 ? N/2 : (N+1)/2 , N);
			
//			System.out.println(Arrays.toString(temp1));
//			System.out.println(Arrays.toString(temp2));
			
			for(int i = 0; i <  (N%2 == 0 ? N/2 : (N+1)/2); i++) {
				if(i < temp1.length)sb.append(temp1[i] + " ");
				if(i < temp2.length)sb.append(temp2[i] + " ");
			}
			
			System.out.printf("#%d %s",t,sb.toString().trim());
			if(t <T)System.out.println();
		}
		
	}
	public static int getPwd(int num) {
		while(true) {
			
		}
	}
}
