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
		
		arr.sort(null);
		
		int lo = 0;
		int hi = N-1;
		int mid = (lo + hi) / 2;
		int min = Integer.MAX_VALUE;
		int numA = 0;
		int numB = 0;
		
		while(lo<hi) {
			int sum = arr.get(lo) + arr.get(hi);
//			System.out.println(lo + " - " + hi);
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				numA = arr.get(lo);
				numB = arr.get(hi);
			}
			
			if(sum < 0) {
				lo++;
			}else if(sum > 0) {
				hi--;
			}else {
				System.out.println(arr.get(lo) + " " + arr.get(hi));
				return;
			}
			
		}
		System.out.println(numA + " " + numB);
		
	}
}

