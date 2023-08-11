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
		
		int[] player = new int[T];
		boolean[] nums = new boolean[1000001];
		int[] answer = new int[1000001];
		player= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for(int a : player)
			nums[a] = true;
		int max = Arrays.stream(player).max().getAsInt();

		for(int i = 0; i < T; i++) {
			for(int x = player[i]*2; x <= max; x+=player[i]) {
				
				if(nums[x]) {
					answer[x]--;
					answer[player[i]]++;
				}
			}
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < T; i++) {
			stringBuilder.append(Integer.toString(answer[player[i]]));
			if(i != T - 1) stringBuilder.append(" ");
		}
		System.out.println(stringBuilder.toString());
	}
	
	public static boolean isPrime(int num) {
		if(num < 3)return true;
		
		for(int i = 2; i < Math.sqrt(num);i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
