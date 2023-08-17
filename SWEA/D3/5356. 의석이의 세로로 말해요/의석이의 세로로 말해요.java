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
		
		for(int t = 1; t <= T; t++) {
			sb = new StringBuilder();
			String[] str = new String[5];
			int[] length = new int[5];
			
			for(int i = 0 ; i < 5; i++) {
				str[i] = br.readLine();
				length[i] = str[i].length();
			}
			
			int maxLen = Arrays.stream(length).max().getAsInt();
			
			for(int i = 0 ; i < maxLen; i++) {
				for(int j = 0 ; j < 5; j++) {
					if(length[j] <= i) continue;
					
					sb.append(str[j].charAt(i));
				}
			}
			System.out.printf("#%d %s",t,sb);
			if(t <T)System.out.println();
		}
		
	}
}
