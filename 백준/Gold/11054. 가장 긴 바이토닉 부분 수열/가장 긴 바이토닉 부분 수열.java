import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] board = new int[T+1];
		int[] reverseBoard = new int[T+1];
		int[] dp = new int[T+1];
		int[] dp2 = new int[T+1];
		int max = 0;
		
		int count = 1;
		while(T-- > 0) {
			board[count] = Integer.parseInt(st.nextToken());
			reverseBoard[reverseBoard.length - count] = board[count]; 
			count++;
		}count--;
		
//		System.out.println(Arrays.toString(board));
//		System.out.println(Arrays.toString(reverseBoard));
		for(int i = 1 ; i <= count; i++) {
			dp[i] = 1;
			dp2[i] = 0;
			for(int j = 1; j <= i; j++) {
				if(board[j] < board[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
				if(reverseBoard[j] < reverseBoard[i] && dp2[i] < dp2[j] + 1) {
					dp2[i] = dp2[j] + 1;
				}
			}
		}
		for(int i = 1 ; i < dp.length; i++) {
//			System.out.println(i);
			int sum = dp[i] + dp2[dp.length - i];
			if(max < sum) max = sum;
		}
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(dp2));
		System.out.println(max);
	}

}


