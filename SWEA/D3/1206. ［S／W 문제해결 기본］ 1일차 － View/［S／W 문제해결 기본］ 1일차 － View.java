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
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			int[] buildings = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 2; i < N - 2; i++) {
				int min = INF;
				for(int x = -2; x <= 2; x++) {
					if(x==0)continue;
					min = Math.min(min, (buildings[i] - buildings[i+x]) > 0 ? buildings[i] - buildings[i+x] : 0);
				}
				
				answer+= min;
			}
			System.out.printf("#%d %d",t,answer);
			if(t != T) System.out.println();
		}
	}
}
//8
//0 0 7 5 4 6 0 0
