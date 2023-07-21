import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static String[][] board;
	public static int[][] visited;
	public static Queue<int[]> qu = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int answer = 0; 
		
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		board = new String[m][n];
		visited = new int[m][n];
		int[] pos = {0,0};
		
		for(int i = 0; i < m; i++) {
			board[i] = br.readLine().split("");
			for(int j = 0; j < n; j++) {
				if(board[i][j].equals("I")) {
					pos[0] = i;
					pos[1] = j;
				}
			}
		}
		
		qu.add(pos);
		visited[pos[0]][pos[1]] = 1;
		
		while(qu.size() > 0) {
			int[] tempPos = qu.remove();
			
			for(int i = 0; i < 4; i++) {
				int X = dx[i] + tempPos[1];
				int Y = dy[i] + tempPos[0];
				
				if(X < 0 || X >= n || Y < 0 || Y >= m)continue;
				if(visited[Y][X] == 1 || board[Y][X].equals("X")) continue;
//				System.out.printf("X : %d, Y : %d -> %s\n",X,Y,board[Y][X]);
				if(board[Y][X].equals("P")) answer++;
				visited[Y][X] = 1;
				int[] t1 = {Y,X};
				qu.add(t1);
				
			}
			
		}
		
		System.out.println(answer == 0 ? "TT" : answer);
		bw.flush();
		bw.close();
	}
}