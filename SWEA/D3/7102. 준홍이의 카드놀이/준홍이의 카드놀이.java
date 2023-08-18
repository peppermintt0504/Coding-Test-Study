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
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			Map<Integer, Integer> memo = new HashMap<>();
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			
			int max = 0;
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					if(memo.containsKey(i+j)) {
						memo.put(i+j,memo.get(i+j)+1);
					}else {
						memo.put(i+j, 1);
					}
					if(memo.get(i+j) > max) {
						max = memo.get(i+j);
					}
				}
			}
			
			for(int n : memo.keySet()) {
				if(max == memo.get(n)) {
					sb.append(n + " ");
				}
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
