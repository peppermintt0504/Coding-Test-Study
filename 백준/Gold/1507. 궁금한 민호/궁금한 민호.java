import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] originBoard = new int[N][N];
		int[][] newBoard = new int[N][N];
		
		for(int i = 0 ; i < N; i++){
			int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			originBoard[i] = temp.clone();
			newBoard[i] = temp;
			
			
		}
		
//		for(int[] i : newBoard) {
//			System.out.println(Arrays.toString(i));
//		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				for(int x = 0; x < N; x++) {
					
					if(i == j || j == x || i == x)continue;
					
					if(originBoard[j][x] > originBoard[j][i] + originBoard[i][x]) {
						System.out.println(-1);
						return;
					}else if(originBoard[j][x] == originBoard[j][i] + originBoard[i][x]) {
						newBoard[j][x] = INF;
					}
				}
			}
		}
		int answer = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				if(newBoard[i][j] !=INF) answer += newBoard[i][j];
			}
		}
		System.out.println(answer);
	}
	
}

