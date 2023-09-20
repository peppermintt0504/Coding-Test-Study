import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
 
public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 1_000_000;

	
	static int[] root;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1 ;t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			root = new int[N+1];
			rank = new int[N+1];
			for(int i = 0 ; i < N+1; i++) root[i] = i;
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			ArrayList<Integer> arr = new ArrayList<>();
			
			for(int i = 1 ; i <= N; i++) {
				if(!arr.contains(find(i))) {
					arr.add(find(i));
				}
			}
			
			System.out.println("#"+t+" " +arr.size());
		}
	}

	public static int find(int x) {
		if(root[x] == x) {
			return x;
		}else {
			return root[x] = find(root[x]);
		}
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x==y)return;
		
		if(rank[x] >= rank[y]) {
			root[y] = x;
		}else {
			root[x] = y;
		}
		
		if(rank[x] == rank[y]) {
			rank[x]++;
		}
	}
}