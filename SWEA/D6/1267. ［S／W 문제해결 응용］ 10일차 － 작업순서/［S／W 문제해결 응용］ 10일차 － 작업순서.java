import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
 
public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 1_000_000;

	
	
	public static void main(String[] args) throws IOException {
		int T = 10;
		
		for(int t = 1 ;t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			ArrayList<ArrayList <Integer>> after = new ArrayList<>();
			int[] weight = new int[N+1];
			
			for(int i = 0; i <= N; i++)after.add(new ArrayList<>());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < M; i++) {
				
				
				
				int pre = Integer.parseInt(st.nextToken());
				int post = Integer.parseInt(st.nextToken());
				
				after.get(pre).add(post);
				weight[post]++;
			}
			
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			boolean[] visited = new boolean[N+1];
			
			for(int i = 1; i <= N; i++) {
				if(weight[i] == 0)dq.add(i);
			}
			
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			while(!dq.isEmpty()) {
				int cur = dq.poll();
				sb.append(cur).append(" ");
				visited[cur] = true;
				
				for(int n : after.get(cur)) {
					weight[n]--;
					if(weight[n] == 0)dq.add(n);
				}
			}
			
			System.out.println(sb.toString().trim());
		}
	}

	
}