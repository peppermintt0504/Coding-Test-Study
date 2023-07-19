import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[][][] board;
	public static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer token = new StringTokenizer(br.readLine()," ");
		
		int[] dx = {0,1,0,-1,0,0};
		int[] dy = {-1,0,1,0,0,0};
		int[] dz = {0,0,0,0,1,-1};
		
		int x = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		int z = Integer.parseInt(token.nextToken());
		
		board = new int[z][y][x];
		
		int tomatoCount = 0;
		int answer = 0;

		for(int t = 0; t < z; t++) {
			for(int i = 0; i < y; i++) {
				board[t][i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				for(int j= 0; j < x; j++) {
					if(board[t][i][j] == 1) {
						int[] temp = {t,i,j,0};
						queue.add(temp);
					}else if(board[t][i][j] == 0) {
						tomatoCount++;
					}
				}
			}
		}
		
		while(queue.size() != 0 && tomatoCount != 0) {
			int[] temp = queue.remove();
			
			int xz = temp[0];
			int xy = temp[1];
			int xx = temp[2];
			int days = temp[3];
			
			for(int i = 0; i < 6; i++) {
				if(xz+dz[i] < 0 || xz+dz[i] >= z ||
					xy+dy[i] < 0 || xy+dy[i] >= y ||
					xx+dx[i] < 0 || xx+dx[i] >= x )
					continue;
				
				if(board[xz+dz[i]][xy+dy[i]][xx+dx[i]] == 0) {
					board[xz+dz[i]][xy+dy[i]][xx+dx[i]] = 1;
					int[] temp1 = {xz+dz[i],xy+dy[i],xx+dx[i],days+1};
					queue.add(temp1);
					tomatoCount--;
					answer = days+1;
				}
			}
			
		}
		
		bw.write(tomatoCount == 0 ? Integer.toString(answer) : Integer.toString(-1));
		
		bw.flush();
		bw.close();
	}
}