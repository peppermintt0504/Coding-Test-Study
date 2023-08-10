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
		for(int t = 0; t < T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] visited= new int[101];
			for(int i = 0; i < nums.length; i++) {
				visited[nums[i]]++;
			}
			int max = 0;
			int number= 0;
			for(int i = 1 ; i <= 100; i++) {
				if(visited[i] >= max) {
					max = visited[i];
					number = i;
				}
			}
			System.out.printf("#%d %d",n,number);
			if(n != 10)System.out.println();
		}
	}
}