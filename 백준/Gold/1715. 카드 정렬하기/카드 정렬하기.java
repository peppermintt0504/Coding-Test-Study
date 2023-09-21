import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;

	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int answer = 0; 
		while(pq.size() > 1) {
			int a = pq.poll();
			int b = pq.poll();
			
			answer += a+b;
			
			pq.add(a+b);
		}
		System.out.println(answer);
	}
}


