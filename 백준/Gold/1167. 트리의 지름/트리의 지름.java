import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static Map<Integer,ArrayList<int[]>> link = new HashMap<>();
	public static int[] visited;
	public static int max = 0;
	public static int maxPoint = 0;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		int answer = 0;
		
		visited = new int[T+1];
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int num = Integer.parseInt(st.nextToken());
			ArrayList<int[]> AT = new ArrayList<>();
			link.put(num,AT);
			
			while(true) {
				int point = Integer.parseInt(st.nextToken());
				if(point == -1)	break;
				int[] temp = {point, Integer.parseInt(st.nextToken())};
				link.get(num).add(temp);
			}
			
		}
		
		visited[1] = 1;
		DFS(1,0);
		
		visited = new int[T+1];
		visited[maxPoint] = 1;
		DFS(maxPoint,0);
		
		System.out.println(max);
		bw.flush();
		bw.close();
	}
	
	public static void DFS(int point, int count) {
		if(max < count) {
			max = count;
			maxPoint = point;
		}
		
		for(int[] te : link.get(point)) {
			if(visited[te[0]] == 0) {
				visited[te[0]] = 1;
				DFS(te[0],count+te[1]);
				visited[te[0]] = 0;
			}
		}
	}
}