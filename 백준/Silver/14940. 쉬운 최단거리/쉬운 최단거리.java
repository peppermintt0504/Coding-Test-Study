import java.io.*;
import java.util.*;

 
 
public class Main {
	
	public static int[][] visited;
	public static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int y = size[0];
		int x = size[1];
		int posX = 0;
		int posY = 0;
		boolean isFind = false;
		
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
		
		visited = new int[size[0]][size[1]];
		board = new int[size[0]][size[1]];
		
		for(int i = 0; i < y;i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			if(isFind)continue;
			for(int j = 0; j < x; j++) {
				if(board[i][j] == 2) {
					posX = j;
					posY = i;
					isFind = true;
					break;
				}
			}
		}
		
		ArrayList<int[]> queue = new ArrayList<>();
		
		int[] temp = {posX,posY,0};
		visited[posY][posX] = -1;
		queue.add(temp);
		
		while(queue.size() != 0) {
			int tX = queue.get(0)[0];
			int tY = queue.get(0)[1];
			int distance = queue.get(0)[2];
			
			queue.remove(0);
			
			for(int i = 0; i < 4; i++) {
				if(tX + dx[i] < 0 || tX + dx[i] >= x || tY + dy[i] < 0 || tY + dy[i] >= y) continue;
				
				if(visited[tY + dy[i]][tX + dx[i]] == 0 && board[tY + dy[i]][tX + dx[i]] == 1) {
					
					visited[tY + dy[i]][tX + dx[i]] = distance + 1;
					int[] t = {tX + dx[i],tY + dy[i],distance + 1};
					queue.add(t);
				}
			}	
		}
		
		visited[posY][posX] = 0;
		
		
		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				if(visited[i][j] == 0 && board[i][j] == 1)	bw.write("-1");
				else										bw.write(Integer.toString(visited[i][j]));
				if(j != x-1)bw.write(" ");
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}
}