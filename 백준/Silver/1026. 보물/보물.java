import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;

	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		Arrays.sort(A);
		Arrays.sort(B);
		int answer = 0;
		for(int i = 0 ; i < N;i++) {
			answer += A[i] * B[N-i-1];
		}
		System.out.println(answer);
	}
}


