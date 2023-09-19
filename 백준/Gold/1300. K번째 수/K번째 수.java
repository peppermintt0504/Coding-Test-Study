import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int lo = 1;
		int hi = K;
		int mid = (lo + hi) / 2;
		
		while(lo<hi) {
			mid = (lo + hi) / 2;
			int count = 0;
			for(int i = 1; i <= N; i++) {
				count += Math.min(N, mid / i);
			}
//			System.out.println(count);
			
			if(K <= count) {
				hi = mid;
			}else {
				lo = mid+1;
			}
		}
		System.out.println(lo);
	}
}

