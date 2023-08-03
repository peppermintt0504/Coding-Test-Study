import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] board = new int[N+1][N+1];
		
		for(int i = 1 ; i <= N; i++) {
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int x = 1; x <= N; x++) {
				board[i][x] = board[i][x-1] + temp[x-1];
			}
		}

		
		for(int i = 0; i < M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st1.nextToken());
			int y1 = Integer.parseInt(st1.nextToken());
			int x2 = Integer.parseInt(st1.nextToken());
			int y2 = Integer.parseInt(st1.nextToken());
			
			int sum = 0;
			
			
			for(int y = x1; y <= x2; y++) {
				sum += board[y][y2] - board[y][y1-1];
			}
			
			bw.write(Integer.toString(sum) + "\n");
			
		}
		
		bw.flush();
		bw.close();
	}
	
}