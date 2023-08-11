import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	public static void main(String[] args) throws IOException{

		int T = Integer.parseInt(br.readLine());
		
		long[] liq = new long[T];
		liq= Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		int left =0;
		int right =T-1;
		int ml =0, mr = 0;
		long min = Long.MAX_VALUE;
		while(left<right) {
			long sum = liq[left]+liq[right];
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				ml = left; mr = right;
			}
			if(sum>=0) {
				right--;	
			}else {
				left++;
			}
		}
		System.out.printf("%d %d\n",liq[ml],liq[mr]);
	}
}
