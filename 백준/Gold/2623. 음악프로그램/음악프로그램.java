import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static Long INF = Long.MAX_VALUE;

	
	
	public static class Singer{
		int no;
		int indegree = 0;
		ArrayList<Integer> next = new ArrayList<>();
		
		public Singer() {}
		public Singer(int no) {
			this.no = no;
		}
		public void clear() {
			this.next.clear();
		}
		@Override
		public String toString() {
			return "Singer [no=" + no + ", indegree=" + indegree + ", next=" + next + "]";
		}
		

	}
	
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer,Singer> memo = new HashMap<>();
		
		for(int i = 1; i <= N; i++) {
			memo.put(i,new Singer(i));
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int[] rule = new int[len];
			for(int x = 0; x < len; x++)
				rule[x] = Integer.parseInt(st.nextToken());

			for(int x = 0; x < rule.length - 1; x++) {
				Singer preSinger = memo.get(rule[x]);
				Singer nextSinger = memo.get(rule[x+1]);
				
				preSinger.next.add(rule[x+1]);
				nextSinger.indegree++;
			}
		}
		
//		for(int s : memo.keySet())
//			System.out.println(memo.get(s));
		
		Queue<Integer> qu = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(memo.get(i).indegree == 0)
				qu.add(i);
		}
		
		int answer = 0;
		while(!qu.isEmpty()) {
			Singer cur = memo.get(qu.poll());
			answer++;
			sb.append(cur.no);
			for(int n : cur.next) {
				Singer next = memo.get(n);
				next.indegree--;
				if(next.indegree==0)
					qu.add(n);
			}
			if(qu.size() > 0)sb.append("\n");
		}
		System.out.println(answer == N ? sb.toString() : 0);
	}
}	
