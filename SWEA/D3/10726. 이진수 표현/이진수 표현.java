import java.io.*;
import java.util.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] binary = Arrays.stream(Integer.toBinaryString(M).split("")).mapToInt(Integer::parseInt).toArray();
			boolean answer = true;
//			System.out.println(Arrays.toString(binary));
			if(binary.length < N) {
				answer = false;
			}else {
				for(int i = 1 ; i <= N; i++) {
					if(binary[binary.length-i] == 0) {
						answer = false;
						break;
					}
				}
			}
			System.out.printf("#%d %s\n",t,answer ? "ON" : "OFF");
		}
	}
}
