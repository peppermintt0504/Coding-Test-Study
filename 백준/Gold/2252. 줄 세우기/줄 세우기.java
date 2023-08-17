import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;

	
	public static class Student{
		int no;
		int indegree;
		ArrayList<Integer> moreTall = new ArrayList<>();
		public Student() {
			// TODO Auto-generated constructor stub
		}
		public Student(int no) {
			this.no = no;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<Integer,Student> measure = new HashMap<>();
		
		int[] stu = new int[N+1];
		
		for(int i = 0 ; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(!measure.containsKey(A)) 
				measure.put(A,new Student(A));
			
			measure.get(A).moreTall.add(B);
			stu[B]++;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 1; i <= N; i++) {
			if(stu[i] == 0) 
				pq.add(i);
		}
		
		while(!pq.isEmpty()) {
			int cur = pq.poll();
			sb.append(cur + " ");
			if(!measure.containsKey(cur)) continue;
			for(int s : measure.get(cur).moreTall) {
				stu[s]--;
				if(stu[s] == 0)
					pq.add(s);
			}
		}
		
		System.out.println(sb.toString().trim());
	}
}	
