import java.util.*;
import java.io.*;


public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static void main(String[] args) throws IOException{
		int T = 10;

		for(int t = 1; t <= T; t++) {
			String num = br.readLine();
			String target = br.readLine();
			String str = br.readLine();
			int count = 0;
			while(str.contains(target)) {
				count++;
				str = str.replaceFirst(target, "-");
			}
			
			bw.write("#" + Integer.toString(t) + " " + Integer.toString(count));
			if(t < T)bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}
