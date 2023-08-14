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
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; t++) {
			String str = br.readLine();
			bw.write("#" + Integer.toString(t) + " "+Integer.toString(isPen(str.split("")) ? 1:0));
			if(t < T)bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
		
	}
	
	public static boolean isPen(String[] str) {
		boolean answer = true;
		for(int i = 0; i < str.length/2 ; i++) {
			if(!str[i].equals(str[str.length - 1 - i])) {
				return false;
			}
		}

		return answer;
	}
}
