import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;

	static int[] root;
	static int[] rank;
	
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] board = new int[N][N];
		root = new int[N];
		rank = new int[N];
		
		for(int i = 0 ; i < N; i++) 
			root[i] = i;
		
		for(int i = 0 ; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int x = 0; x < N; x++) {
				if(i == x) continue;
				if(board[i][x] == 1) {
					union(i,x);
				}
			}
		}
		
//		System.out.println(Arrays.toString(root));
		
		int[] plan = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int planRoot = find(plan[0]-1);
		for(int n : plan) {
			if(planRoot != find(n-1)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
	
	static int find(int x) {
		  if (root[x] == x) {
		      return x;
		  } else {
		      return root[x] = find(root[x]);
		  }
		}
	
	static void union(int x, int y){
		   x = find(x);
		   y = find(y);

		   if(x == y)
		     return;

		   if(rank[x] < rank[y]) {
		     root[x] = y; 
		   } else {
		     root[y] = x; 

		     if(rank[x] == rank[y])
		       rank[x]++; 
		   }
		}
}
