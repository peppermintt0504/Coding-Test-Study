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
		int T = 10;
		
		String[] open = {"{", "[", "(","<"};
		String[] close = {"}", "]", ")",">"};
		
		for(int t = 0 ; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] str = br.readLine().split("");
			Stack<Integer> stack = new Stack<>();
			int answer = 1;
			
			for(int i = 0; i < str.length; i++) {
				boolean isOpen = true;
				int id = -1;
				for(int x = 0; x < 4; x++) {
					if(open[x].equals(str[i])) {
						id = x;
						break;
					}
				}
				
				if(id == -1) {
					isOpen = false;
					for(int x = 0; x < 4; x++) {
						if(close[x].equals(str[i])) {
							id = x;
							break;
						}
					}
				}
				
//				System.out.printf("%s -> %s, %s\n",str[i],Boolean.toString(isOpen), stack.toString());
				if(isOpen) {
					stack.push(id);
				}else {
					int cur = stack.pop();
					if(cur != id) {
						answer = 0;
						break;
					}
				}
			}
			
			System.out.printf("#%d %d",t+1,answer);
			if(t < T-1)System.out.println();
		}
		
	}
}
