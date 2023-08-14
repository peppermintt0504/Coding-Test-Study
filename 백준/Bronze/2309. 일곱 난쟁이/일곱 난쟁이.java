import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static String[] str;
	public static void main(String[] args) throws IOException{
		int T = 9;
		
		int[] nums = new int[T];
		
		for(int i = 0; i < T; i++)nums[i] = Integer.parseInt(br.readLine());
		
		
		for(int i = 0; i < 8;i++) {
			for(int j = i + 1; j < 9; j++) {
				int sum = 0;
				int[] arr= new int[7];
				int count = 0;
				for(int x = 0; x < 9; x++) {
					if(x == i || x == j) continue;
					sum+=nums[x];
					arr[count] = nums[x];
					count++;
				}
				if(sum == 100) {
					for(int n : Arrays.stream(arr).sorted().toArray()) {
						sb.append(n + "\n");
					}
					System.out.print(sb.toString());
					return;
				}
			}
		}
	}

}
