import java.util.*;
import java.util.stream.*;
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
		Stack<Integer> stack = new Stack<>();
		for(int t = 0 ; t < T; t++) {
			int answer = 0;
			String[] str = br.readLine().split("");
			boolean isCutting = false;
		
			for(int i = 0; i < str.length; i++) {
				if(str[i].equals("(")){
					stack.push(0);
					isCutting = false;
				}else {
					if(isCutting) {
						stack.pop();
						answer++;
					}else {
						stack.pop();
						isCutting = true;
						answer += stack.size();
					}
					
				}
				
			}
			
			System.out.printf("#%d %d",t+1,answer);
			if(t < T-1)System.out.println();
		}
		
	}
}
