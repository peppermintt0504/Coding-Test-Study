import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static Long INF = Long.MAX_VALUE;

	public static class Dot{
		int x;
		int y;
		public Dot() {}
		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static ArrayList<Dot> whiteDots = new ArrayList<>();
	public static ArrayList<Dot> blackDots = new ArrayList<>();
	
	public static int[][] board = new int[19][19];
	
	public static void main(String[] args) throws IOException{
		
		for(int i = 0 ; i < 19 ; i ++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int x = 0; x < 19; x++) {
				if(board[i][x] == 1) {
					blackDots.add(new Dot(x,i));
				}else if(board[i][x] == 2) {
					whiteDots.add(new Dot(x,i));
				}
			}
		}
		
		for(Dot b : blackDots) {
			if(checkWin(1,b)) {
				System.out.println(1);
				System.out.printf("%d %d\n",b.y+1,b.x+1);
				return;
			}
		}
		for(Dot w : whiteDots) {
			if(checkWin(2,w)) {
				System.out.println(2);
				System.out.printf("%d %d\n",w.y+1,w.x+1);
				return;
			}
		}
		System.out.println(0);
	}
	public static boolean checkWin(int checker, Dot dot) {
		boolean check = false;
		
//		System.out.printf("%d %d\n",dot.x+1,dot.y+1);
		int x = dot.x;
		int y = dot.y;
		
		int count = 0;
		for(int i = 0 ; i < 5; i++) {
			if(x + i < 19 && board[y][x+i] == checker) {
				count++;
			}else {
				break;
			}
		}
		if(count == 5 && !(x - 1 >= 0 && board[y][x-1] == checker) && !(x + 5 < 19 && board[y][x+5] == checker)) {
			check= true;
			return check;
		}
		count = 0;
		for(int i = 0 ; i < 5; i++) {
			if(y + i < 19 && board[y+i][x] == checker) {
				count++;
			}else {
				break;
			}
		}
		if(count == 5 && !(y - 1 >= 0 && board[y-1][x] == checker) && !(y + 5 < 19 && board[y+5][x] == checker)) {
			check= true;
			return check;
		}
		
		count = 0;
		for(int i = 0 ; i < 5; i++) {
			if(x + i < 19 && y + i < 19 && board[y+i][x+i] == checker) {
				count++;
			}else {
				break;
			}
		}
		if(count == 5 && !(x - 1 >= 0 && y - 1 >= 0 && board[y-1][x-1] == checker) && !(x + 5 < 19 && y + 5 < 19 && board[y+5][x+5] == checker)) {
			check= true;
			return check;
		}
		
		
		count = 0;
		for(int i = 0 ; i < 5; i++) {
			if(x + i < 19 && y - i >= 0 && board[y-i][x+i] == checker) {
				count++;
			}else {
				break;
			}
		}
		if(count == 5 && !(x - 1 >= 0 && y + 1 < 19 && board[y+1][x-1] == checker) && !(x + 5 < 19 && y - 5 >= 0 && board[y-5][x+5] == checker)) {
			check= true;
			return check;
		}
		return check;
	}
}	


