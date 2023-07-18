import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;

 
 
public class Main {
	public static int[][] board;
	public static ArrayList<int[]> tomatos;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] temp = br.readLine().split(" ");
		
		int answer = 0;
		
		int row = Integer.parseInt(temp[0]);
		int col = Integer.parseInt(temp[1]);
		
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		StringTokenizer st;
		board = new int[col][row];
		int zero = 0;
		tomatos = new ArrayList<int[]>();		
		for(int i = 0 ; i < col; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < row; j++) {
				int temp1 = Integer.parseInt(st.nextToken());
				
				board[i][j] = temp1;
				if(temp1 == 0)zero++;
				else if (temp1 == 1) {
					int[] t = new int[2];
					t[0] = j;
					t[1] = i;
					tomatos.add(t);
				}
			}
		}
		
		int c = 0;
		
		while(true) {
			ArrayList<int[]> queue = new ArrayList<int[]>();
			
			for(int[] to : tomatos) {
				queue.add(to);
			}
			tomatos = new ArrayList<int[]>();		
			int change = 0;
			
			for(int[] to : queue) {
				int y = to[1];
				int x = to[0];
				for(int z = 0; z < 4; z++) {
					if(y+dy[z] < 0 || y+dy[z] >= col || x+dx[z] < 0 || x+dx[z] >= row) continue;
					if(board[y+dy[z]][x+dx[z]] == 0) {
						board[y+dy[z]][x+dx[z]] = 1;
						int[] t = new int[2];
						t[0] = x+dx[z];
						t[1] = y+dy[z];
						tomatos.add(t);
						change++;
				}
			}

					
			
			}
			
			if(change == 0) {
				break;
			}else {
				answer++;
				c += change;
			}
			
		}
		
		
		System.out.println(zero == c ? answer : -1);
	}
}