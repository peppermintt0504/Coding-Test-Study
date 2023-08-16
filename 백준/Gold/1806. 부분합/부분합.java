import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;

	

	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] temp =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] nums = new int[N+2];
		for(int i = 1 ; i <= N; i++) {
			nums[i] = nums[i-1] + temp[i-1];
		}
		
		
		int left = 0;
		int right = 0;
		int answer = INF;
//		System.out.println(Arrays.toString(nums));
		while(right <= N && left <= N) {
			int sum = nums[right] - nums[left];
			
			if(sum >= M) {
//				System.out.printf("%d %d - %d %d\n",left,nums[left], right, nums[right]);
				answer = Math.min(answer, right - left);
				left++;
			}else {
				right++;
			}
		}
		System.out.println(answer == INF ? 0 : answer);
	}

	

}	
