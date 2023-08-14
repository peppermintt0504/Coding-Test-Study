import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static String[] str;
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] counts = new int[N];
		int cur = 0;
		int count = -1;
		
		while(true) {
			int catched = counts[cur];
			
			if(catched == M) {
				System.out.println(count);
				return;
			}
			
			if(catched % 2 == 0) {
				if(cur < C) {
					cur = N - C + cur;
				}else {
					cur -= C;
				}
			}else {
				cur = (cur + C) % N;
			}
			
			counts[cur]++;
			count++;
		}
	}
}
