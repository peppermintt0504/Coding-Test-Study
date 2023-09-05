import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Build implements Comparable<Build>{
		int time;
		int no;
		
		public Build() {}
		public Build(int time, int no) {
			this.time = time;
			this.no = no;
		}
		@Override
		public int compareTo(Build o) {
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		ArrayList<ArrayList<Integer>> data = new ArrayList<>();
		for(int i = 0; i < T+1; i++)data.add(new ArrayList<Integer>());
		int[] weight = new int[T+1];
		boolean[] visited = new boolean[T+1];
		int[] buildingTimes = new int[T+1];
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int time = Integer.parseInt(st.nextToken());
			buildingTimes[t] = time;
			
			while(true) {
				int no = Integer.parseInt(st.nextToken());
				if(no == -1) break;
				
				weight[t]++;
				data.get(no).add(t);
			}
		}
		
		
		PriorityQueue<Build> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= T; i++) {
			if(weight[i] == 0) {
				pq.add(new Build(buildingTimes[i],i));
			}
		}
		
		int[] answer = new int[T];
		while(!pq.isEmpty()) {
			Build cur = pq.poll();
			
			if(visited[cur.no])continue;
			visited[cur.no] = true;
			answer[cur.no-1] = cur.time;
			for(int b : data.get(cur.no)) {
				weight[b]--;
				if(weight[b] == 0) {
					pq.add(new Build(cur.time + buildingTimes[b],b));
				}
			}
			
		}
		
		for(int i = 0; i < T; i++) {
			sb.append(answer[i] + "\n");
		}
		System.out.println(sb.toString());
	}
	
}