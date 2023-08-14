import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static String[] str;
	public static void main(String[] args) throws IOException{

		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] answer = new int[N];
		for(int i = 0 ; i < N; i++) {
			answer[i] += i + 1;
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int temp = answer[a];
			answer[a] = answer[b];
			answer[b] = temp;
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int n : answer) {
			sb.append(n + " ");
		}
		System.out.println(sb.toString().trim());
	}

}
