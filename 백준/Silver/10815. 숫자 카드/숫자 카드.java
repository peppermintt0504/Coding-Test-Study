import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;


	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		long[] Ncards = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
		int M = Integer.parseInt(br.readLine());
		long[] Mcards = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		StringBuilder sb = new StringBuilder();
		int[] answer = new int[M];
		for(int i = 0; i < M; i++) {
			
			int left = 0;
			int right = N-1;
			int mid = (left + right) / 2;
			
			long target = Mcards[i];
			
			while(left <= right) {
				if(Ncards[mid] > target) {
					right = mid-1;
				}else if(Ncards[mid] < target){
					left = mid+1;
				}else {
					right = mid;
					left = mid;
					break;
				}
				mid = (left + right) / 2;
			}
			if(Ncards[mid] == target)answer[i] =1;
			else answer[i] = 0;
		}
		for(int n : answer) sb.append(n + " ");
		System.out.println(sb.toString().trim());
	}
	
}
