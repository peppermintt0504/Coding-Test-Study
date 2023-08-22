import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();

	public static boolean[] visited;
	public static boolean[] checked;
	public static int[] to;
	public static int count = 0;
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			count = 0;
			to = new int[N+1];
			visited = new boolean[N+1];
			checked = new boolean[N+1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int n = 1; n <= N; n++) {
				int num = Integer.parseInt(st.nextToken());
				
				to[n] = num;
			}
			for(int i = 1; i <= N; i++)
				DFS(i);
			
			System.out.println(N-count);
		}
		
	}
	public static void DFS(int n) {
		
		
		if(visited[n]) return;
		visited[n] = true;
		
		
		if(!visited[to[n]]) {
			DFS(to[n]);
		}else {
			if(!checked[to[n]]) {
				int next = to[n];
				count++;
				for(int i=next; i != n; i = to[i])
                    count++;
			}
		}
		
		checked[n] = true;
	}

}	


