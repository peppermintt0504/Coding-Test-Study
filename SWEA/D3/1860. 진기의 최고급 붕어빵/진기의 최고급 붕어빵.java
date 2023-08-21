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
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				pq.add(Integer.parseInt(st.nextToken()));
			}
			
			int time = 0;
			int count = 0;
			boolean isPossible = true;
			while(!pq.isEmpty()) {
				int cur = pq.poll();
				count++;
				if(time < cur) {
					time = cur;
				}
				
				if( (int) Math.floor(time / M) * K >= count) {
					
				}else {
					isPossible = false;
					break;
				}
			}
			
			
			
			System.out.printf("#%d %s",t,isPossible ? "Possible" :"Impossible");
			if(t <T)System.out.println();
		}
		
	}
	public static int getPwd(int num) {
		while(true) {
			
		}
	}
}
