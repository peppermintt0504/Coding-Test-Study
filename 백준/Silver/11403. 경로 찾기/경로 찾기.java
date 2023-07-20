import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[][] board;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		board = new int[T][T];
		for(int t = 0; t < T; t++){
			int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();
			board[t] = numList;
		}
		
		for(int i = 0 ; i < T; i++) {
			for(int j = 0; j < T; j++) {
				if(i == j) continue;
				if(board[j][i] == 1) {
					for(int z = 0; z < T; z++) {
						board[j][z] = Math.max(board[i][z], board[j][z]);
					}
				}
				
			}
		}
		
		for(int[] a : board) {
			for(int i = 0; i < T; i++) {
				bw.write(Integer.toString(a[i]));
				if(i != T-1) bw.write(" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}