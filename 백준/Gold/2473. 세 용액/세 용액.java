import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static Long INF = Long.MAX_VALUE;

	public static ArrayList<Integer> preorder = new ArrayList<>();
	public static int[] inorder;
	public static int[] postorder;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
	
		long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).sorted().toArray();
//		System.out.println(Arrays.toString(nums));
	
		long min = INF;
		long[] answer = new long[3];
		for(int i = 0 ; i < N - 2 ; i++) {
			long exNum = nums[i];
//			System.out.printf("%d ->>>>>\n",exNum);
			int left = i + 1;
			int right = N-1;
			
			while(left < right) {
				long sum = nums[left] + nums[right] + exNum;
//				System.out.printf("%d %d\n",nums[left] , nums[right]);
				if(min > Math.abs(sum)) {
					min = Math.abs(sum);
					answer[0] = exNum;
					answer[1] = nums[left];
					answer[2] = nums[right];
				}else {
					if(sum > 0) {
						right--;
					}else {
						left++;
					}
				}
			}
		}
		System.out.printf("%d %d %d",answer[0], answer[1], answer[2]);
	}
}	
