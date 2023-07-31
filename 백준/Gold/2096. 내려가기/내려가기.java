import java.util.*;
import java.io.*;
public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int[] maxDp;
	public static int[] minDp;
	public static int[] board;
	
	public static void main(String[] args) throws IOException{
		
		int T = Integer.parseInt(br.readLine());
		maxDp = new int[3];
		minDp =  new int[3];
		board = new int[T];
		
		for(int i = 0; i < T; i++) {
			board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			if(i == 0) {
				maxDp[0] = minDp[0] = board[0];
				maxDp[1] = minDp[1] = board[1];
				maxDp[2] = minDp[2] = board[2];
			}else {
				int temp1 = maxDp[0];
				int temp2 = maxDp[2];
				
				maxDp[0] = Math.max(maxDp[0], maxDp[1]) + board[0];
				maxDp[2] = Math.max(maxDp[2], maxDp[1]) + board[2];
				maxDp[1] = Math.max(temp1, Math.max(temp2, maxDp[1])) + board[1];
				
				temp1 = minDp[0];
				temp2 = minDp[2];
				
				minDp[0] = Math.min(minDp[0], minDp[1]) + board[0];
				minDp[2] = Math.min(minDp[2], minDp[1]) + board[2];
				minDp[1] = Math.min(temp1, Math.min(temp2, minDp[1])) + board[1];
			}
		}

		System.out.printf("%d %d\n",Arrays.stream(maxDp).max().getAsInt(),Arrays.stream(minDp).min().getAsInt());
	}
}
