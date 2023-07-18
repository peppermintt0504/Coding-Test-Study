import java.io.*;
import java.util.*;

 
 
public class Main {
	public static ArrayList<ArrayList<Integer>> nodes;
	public static int[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] temp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = temp1[0];
		int M = temp1[1];
		
		nodes = new ArrayList<ArrayList<Integer>>();
		visited = new int[N+1];
		for(int i = 0; i <= N; i++) 
			nodes.add(new ArrayList<Integer>());
		
		for(int i = 0; i < M; i++) {
			int[] temp2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			nodes.get(temp2[0]).add(temp2[1]); 
			nodes.get(temp2[1]).add(temp2[0]);
		}
		
		int count = 0;

		for(int i = 1; i <= N;i++) {
			if(visited[i] != 0)continue;
			DFS(i);
			count++;
		}
		

		bw.write(Integer.toString(count));
		
		bw.flush();
		bw.close();
		
	}
	
	public static void DFS (int a) {
		if(visited[a] != 0)return;
		visited[a] = 1;
		
		for(int v : nodes.get(a)) {
			if(visited[v] == 0) {
				DFS(v);
				
			}
		}
	}
	
}