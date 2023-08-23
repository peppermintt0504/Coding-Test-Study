import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};
	public static String[][] board;
	public static ArrayList<Pos> destinations = new ArrayList<>(); 
	public static ArrayList<String> doors = new ArrayList<>();
	public static ArrayList<String> keys = new ArrayList<>(); 
	public static class Pos{
		int x;
		int y;
		int key;
		
		public Pos() {}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
			this.key = 0;
		}
		public Pos(int x, int y, int key) {
			this.x = x;
			this.y = y;
			this.key = key;
		}
		@Override
		public String toString() {
			return "pos => x : " + x + ", y = " + y + " key = " + Integer.toBinaryString(key);
		}
	}
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		
		board = new String[col][row];
		Pos curPos = new Pos();
		
		for(int c = 0; c < col;c++) {
			board[c] = br.readLine().split("");
			
			for(int r = 0; r < row; r++) {
				if(board[c][r].equals("0")) {
					curPos.x = r;
					curPos.y = c;
				}else if(board[c][r].equals("1")) {
					destinations.add(new Pos(r,c));
				}else if(board[c][r].codePointAt(0) >= "A".codePointAt(0) && board[c][r].codePointAt(0) <= "Z".codePointAt(0)) {
					if(!doors.contains(board[c][r]))
						doors.add(board[c][r]);
				}else if(board[c][r].codePointAt(0) >= "a".codePointAt(0) && board[c][r].codePointAt(0) <= "z".codePointAt(0)) {
					if(!keys.contains(board[c][r]))
						keys.add(board[c][r]);
				}
			}
		}
		
		doors.sort(null);

		boolean[][][] visited = new boolean[col][row][1<<doors.size()];
		Queue<Pos> qu = new LinkedList<>();
		Queue<Integer> count = new LinkedList<>();
		

		
		
		qu.add(curPos);
		count.add(0);
		
		boolean possible = false;
		while(!qu.isEmpty()) {
			Pos cur = qu.poll();
			int x = cur.x;
			int y = cur.y;
			int key = cur.key;
			int c = count.poll();
			
			
			if(board[y][x].equals("1")) {
				System.out.println(c);
				possible = true;
				break;
			}
			
			if(visited[y][x][key])continue;
			visited[y][x][key] = true;
			
			for(int i = 0 ; i < 4; i++) {
				int mx = x + dx[i];
				int my = y + dy[i];
				if(mx < 0 || mx >= row || my < 0 || my >= col || board[my][mx].equals("#") 
						|| visited[my][mx][key]) continue;
			
				if( board[my][mx].codePointAt(0) >= "A".codePointAt(0) && board[my][mx].codePointAt(0) <= "Z".codePointAt(0) && (key & (1 << doors.indexOf(board[my][mx]))) != (1 << doors.indexOf(board[my][mx]))) {
					continue;
				}
				
				if(board[my][mx].codePointAt(0) >= "a".codePointAt(0) 
						&& board[my][mx].codePointAt(0) <= "z".codePointAt(0)) {
					char target = (char) (board[my][mx].codePointAt(0) - 32);
					String str = Character.toString(target);
					if(doors.contains(str)) {
						int tempKey = key | (1<<doors.indexOf(str));
						qu.add(new Pos(mx,my,tempKey));
						count.add(c+1);
					}else {
						qu.add(new Pos(mx,my,key));
						count.add(c+1);
					}
				}else {
					qu.add(new Pos(mx,my,key));
					count.add(c+1);
				}
			}
		}
		if(!possible)System.out.println(-1);
		
	}
}	