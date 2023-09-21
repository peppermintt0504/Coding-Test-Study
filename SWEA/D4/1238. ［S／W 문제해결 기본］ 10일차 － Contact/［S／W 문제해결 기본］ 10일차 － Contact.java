import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
 
public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 1_000_000;

	static class Call{
		int to;
		int depth;
		
		public Call() {}
		public Call(int to, int depth) {
			this.to = to;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		int T = 10;
		
		for(int t = 1 ;t <= T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			
			Map<Integer,ArrayList<Integer>> memo = new HashMap<>();
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N/2; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				if(!memo.containsKey(start)) {
					memo.put(start,new ArrayList<>());
					memo.get(start).add(end);
				}else {
					if(!memo.get(start).contains(end)) {
						memo.get(start).add(end);
					}
				}
				
			}
			
//			for(int n : memo.keySet())System.out.println(n+ " : " + memo.get(n).toString());
			
			ArrayDeque<Call> dq = new ArrayDeque<>();
			ArrayList<Integer> visited = new ArrayList<>();
			
			dq.add(new Call(S,1));
			
			
			int lastDepth = 0;
			ArrayList<Integer> answer = new ArrayList<>();
			while(!dq.isEmpty()) {
				Call cur = dq.poll();
				
				if(visited.contains(cur.to))continue;
				visited.add(cur.to);
				
				if(lastDepth<cur.depth) {
					lastDepth = cur.depth;
					answer.clear();
					answer.add(cur.to);
				}else if(lastDepth == cur.depth) {
					answer.add(cur.to);
				}
				
				if(!memo.containsKey(cur.to))continue;
				for(int n : memo.get(cur.to)) {
					if(visited.contains(n))continue;
					dq.add(new Call(n,cur.depth+1));
				}
			}
			
//			System.out.println(visited.toString());
//			System.out.println(answer.toString());
			System.out.print("#" + t + " " +answer.stream().reduce(0,(x,v)-> x < v ? v : x));
			if(t != T)System.out.println();
		}
	}

	
}