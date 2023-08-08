import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static int N;
	public static int M;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[] visited= new boolean[N];

		

		combination(visited,M,0,0);
		
		for(int i = 0; i < temp.size(); i++) {
			boolean[] c = temp.get(i);
			int count = 0;
			for(int x = 0; x< N; x++) {
				if(c[x]) {
					bw.write(Integer.toString(x+1));
					count++;
					if(count != M) bw.write(" ");
				}
				
			}
			if(i != temp.size() - 1) bw.write("\n");
		}
			
		
		
		
		bw.flush();
		bw.close();
	}
	
	public static ArrayList<boolean[]> temp = new ArrayList<>();
	public static void combination(boolean[] visited, int target, int depth, int start) {
		if(target == depth) {
			temp.add(visited.clone());
			return;
		}
		
		for(int i = start; i < visited.length ;i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			combination(visited,target,depth+1,i+1);
			visited[i] = false;
			
		}
	}

}

