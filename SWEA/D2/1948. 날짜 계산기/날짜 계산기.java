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
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int A = y1;
			int B = y2;
			
			for(int i = 0 ; i < x1 - 1; i++) {
				A += months[i];
			}
			for(int i = 0 ; i < x2 - 1; i++) {
				B += months[i];
			}
			
			System.out.printf("#%d %d",t,B - A + 1);
			if(t <T)System.out.println();
		}
		
	}
}
