import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int S = Integer.parseInt(br.readLine());
		arr.sort(null);
		
		int lo = 0;
		int hi = arr.get(N-1) + 1;
		
		while(lo < hi) {
			int mid = (lo+hi) / 2;
			
			int sum = arr.stream().map((a)-> a >= mid ? mid : a).reduce(0, (a,b) -> a+b);
//			System.out.println(mid + " -> " + sum);
			
			if(sum <= S) {
				lo = mid+1;
			}else {
				hi = mid;
			}
		}
		System.out.println(lo-1);
	}
}

