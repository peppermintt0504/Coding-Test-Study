import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		int answer =0;
		while(T --> 0) {
			boolean isRight = true;
			String[] str = br.readLine().split("");
			boolean[] visited= new boolean[26];
			
			for(int i = 0 ; i < str.length;i++) {
				String s = str[i];
				if(i>0 && s.equals(str[i-1])) {
					continue;
				}
				if(visited[s.charAt(0)-'a']) {
					isRight=false;
					break;
				}
				visited[s.charAt(0)-'a'] = true;
			}
			
			if(isRight)answer++;
		}
		
		System.out.println(answer);
	}
}
