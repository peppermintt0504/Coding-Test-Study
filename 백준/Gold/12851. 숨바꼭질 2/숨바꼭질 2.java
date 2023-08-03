import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(N == K) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		int[] visited = new int[200005];
		Queue<Integer> qu = new LinkedList<>();
		Queue<Integer> count = new LinkedList<>();
		
		qu.add(N);
		count.add(0);
		
		int time = 10000000;
		int routeCount = 0;
		
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			int curCount = count.poll();
			
			if(cur == K) {
				time = curCount;
				routeCount++;
			}
			
			if(curCount > time) {
				break;
			}
			
			if(visited[cur] == 0) {
				visited[cur] = curCount;
			}else {
				if(!(visited[cur] == curCount)) 
					continue;
			}
			
			
			
			if(cur > 0) {
				qu.add(cur - 1);
				count.add(curCount + 1);
			}
			if(cur < K) {
				qu.add(cur + 1);
				count.add(curCount + 1);
			}
			if(cur <= K + 1 && cur != 0) {
				qu.add(cur * 2);
				count.add(curCount + 1);
			}
		}
		System.out.println(time);
		System.out.println(routeCount);
	}
	
}