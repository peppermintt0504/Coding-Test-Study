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
		int T = 20;
		float answer = 0;
		float count = 0;
		String[] gList = {"A+", "A0" ,"B+", "B0", "C+", "C0", "D+", "D0", "F"};
		
		while(T --> 0) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			float score = Float.parseFloat(st.nextToken());
			String g = st.nextToken();
			
			float gScore = 0;
			for(int i = 0 ; i < gList.length; i++) {
				if(gList[i].equals(g))gScore = (float) (9-i) / 2;
			}
			
			if(g.equals("F")) gScore = (float) 0.0;
			if(!g.equals("P")) {
				answer += score * gScore;
				count+= score;
			}
			
			
			
		}
		
		System.out.println(answer / count);
	}
}
