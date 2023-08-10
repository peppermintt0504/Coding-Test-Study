import java.util.*;
import java.io.*;


public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= T; i++) {
			
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			float max = 0;
			float min = INF;
			float sum = 0;
			
			for(int x = 0; x <10 ;x++) {
				max = Math.max(max, nums[x]);
				min = Math.min(min, nums[x]);
				sum += nums[x];
			}
			
			System.out.printf("#%d %d",i,Math.round((sum - max - min) / 8));
			if(i != T)System.out.println();
		}
	}
}
