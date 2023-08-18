import java.util.*;
import java.util.stream.*;
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
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			ArrayDeque<Integer> dq = new ArrayDeque<>();
			
			for(int i = 0; i < nums.length; i++) 
				dq.add(nums[i]);
			
			
			sb = new StringBuilder();
			
			int count = 1;
			while(dq.peekLast() > 0) {
				int target = dq.poll();
				target -= count;
				dq.add(target);
				
				count = count % 5 + 1;
			}
			
			int M = dq.size();
			for(int i = 0 ; i < M; i++) {
				int num = dq.poll();
				if(i == M - 1 && num < 0) num = 0;
				sb.append(num + " ");
			}
			
			System.out.printf("#%d %s",t,sb.toString().trim());
			if(t <T)System.out.println();
		}
		
	}
	public static int getPwd(int num) {
		while(true) {
			
		}
	}
}
