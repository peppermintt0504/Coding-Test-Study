import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
    
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] board = new int[N][N];
			int answer = 0;
			
			for(int i = 0; i < N; i++)	board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			
			for(int i = 0; i < N - 2; i++) {
				for(int j = 1; j < N - 1; j++) {
					int a = 1;
					
					while(i + a < N && j + a < N) {
						int b = 1;
						while(i + a + b < N && j - b >= 0) {
							ArrayList<Integer> temp = new ArrayList<>();
							temp.add(board[i][j]);
							int curX = j;
							int curY = i;
							boolean isAnswer = true;
							
							for(int x = 0; x < a; x++) {
								curX++;
								curY++;
								if(temp.contains(board[curY][curX])) {
									isAnswer = false;
								}
								temp.add(board[curY][curX]);
							}
							for(int x = 0; x < b; x++) {
								curX--;
								curY++;
								if(temp.contains(board[curY][curX])) {
									isAnswer = false;
								}
								temp.add(board[curY][curX]);
							}
							for(int x = 0; x < a; x++) {
								curX--;
								curY--;
								if(temp.contains(board[curY][curX])) {
									isAnswer = false;
								}
								temp.add(board[curY][curX]);
							}
							for(int x = 0; x < b - 1; x++) {
								curX++;
								curY--;
								if(temp.contains(board[curY][curX])) {
									isAnswer = false;
								}
								temp.add(board[curY][curX]);
							}
							if(isAnswer)answer = Math.max(answer, ((a+1) * (b+1)) - ((a-1) * (b-1)));
							b++;
						}
						
						a++;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,answer == 0 ? -1 : answer);
		}
	}
}
