import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static String[][] board;
	public static int[][] visited;
	public static int[][] RGvisited;
	public static Queue<int[]> qu;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		board = new String[T][T];
		visited = new int[T][T];
		RGvisited = new int[T][T];
		
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		
		for(int t = 0; t < T; t++){
			String[] temp =br.readLine().split("");
			board[t] = temp;
		}
		
		String color = "";
		int count = 1;
		

		
		for(int i = 0 ; i < T; i++) {
			for(int j = 0; j < T; j++) {
				if(visited[i][j] != 0)continue;
				
				qu = new LinkedList<>();
				
				int[] temp = {i,j};
				qu.add(temp);
				
				color = board[i][j];
				
				while(qu.size() > 0) {
					int[] val = qu.remove();
					
					for(int a = 0; a < 4; a++) {
						int x = val[1] + dx[a];
						int y = val[0] + dy[a];
						
						if(x < 0 || x >= T || y < 0 || y >= T || visited[y][x] != 0 || !board[y][x].equals(color)) continue;
						
						visited[y][x] = count;
						int[] temp1 = {y,x};
						qu.add(temp1);
					}
				}
				count++;
			}
		}
		
		int RGcount = 1;
		
		for(int i = 0 ; i < T; i++) {
			for(int j = 0; j < T; j++) {
				if(RGvisited[i][j] != 0)continue;
				
				qu = new LinkedList<>();
				
				int[] temp = {i,j};
				qu.add(temp);
				
				boolean isRG = false;
				color = board[i][j];
				if(color.equals("R") || color.equals("G")) isRG = true;
				
				while(qu.size() > 0) {
					int[] val = qu.remove();
					
					for(int a = 0; a < 4; a++) {
						int x = val[1] + dx[a];
						int y = val[0] + dy[a];
						
						if(x < 0 || x >= T || y < 0 || y >= T || RGvisited[y][x] != 0) continue;
						
						if(isRG) {
							if(board[y][x].equals("R") || board[y][x].equals("G")) {
								RGvisited[y][x] = count;
								int[] temp1 = {y,x};
								qu.add(temp1);
							}
						}else {
							if(board[y][x].equals(color)) {
								RGvisited[y][x] = count;
								int[] temp1 = {y,x};
								qu.add(temp1);
							}
						}
						
						
					}
				}
				RGcount++;
			}
		}
		
//		for(int[] z : visited) {
//			System.out.printf("[ ");
//			for(int x : z) {
//				System.out.printf("%d ",x);
//			}
//			System.out.println("]");
//		}
//		
//		for(int[] z : RGvisited) {
//			System.out.printf("[ ");
//			for(int x : z) {
//				System.out.printf("%d ",x);
//			}
//			System.out.println("]");
//		}
		System.out.printf("%d %d\n",count-1, RGcount-1);
		bw.flush();
		bw.close();
	}
}