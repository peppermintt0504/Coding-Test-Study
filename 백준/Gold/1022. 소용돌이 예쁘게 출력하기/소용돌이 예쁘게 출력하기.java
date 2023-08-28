import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int y1 = -Integer.parseInt(st.nextToken());
		int x1 = Integer.parseInt(st.nextToken());
		int y2 = -Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());

		long[][] board = new long[y1 - y2 + 1][x2 - x1 + 1];
		
		
		long max = 0;
		for(int y = -y1; y <= -y2; y++) {
			for(int x = x1; x <= x2; x++) {
//				System.out.printf("%d  %d \n",x,-y);
				long num = getNum(x,-y);
				max = Math.max(max, num);
				board[y1 + y][x - x1] = num;
			}
		}
		
		int maxLen = Long.toString(max).length();
		
		for(int i = 0; i < y1 - y2 +1; i++) {
			for(int j = 0; j < x2-x1+1; j++){
				long temp = board[i][j];
				int len = Long.toString(temp).length();
				
				while(len < maxLen) {
					sb.append(" ");
					len++;
				}
				
				sb.append(temp);
				
				if(j != x2 - x1)sb.append(" ");
			}
			if(i != y1 - y2)sb.append("\n");
		}
		System.out.println(sb);
//		System.out.println(getNum(2, 2));
	}
	
	public static int getSection(int x, int y) {
		if(Math.abs(x) <= Math.abs(y)) {
			if(y >= 0)
				return 1;
			else
				return 3;
		}else {
			if(x > 0)
				return 4;
			else
				return 2;
		}
	}
	
	public static long getNum(int x, int y) {
		int section = getSection(x,y);
//		System.out.println(section);
		if(section == 1) {
			long temp = (int) Math.pow(2*y, 2) - 2*y + 1;
			temp += y - x;
			return temp;
		}else if(section == 2) {
			long temp = (int) Math.pow(2*x, 2) + 1;
			temp += -x - y;
			return temp;
		}
		else if(section == 3) {
			long temp = (int) Math.pow(2*y, 2) - 2*y + 1;
			temp += -y + x;
			return temp;
		}else {
			long temp = (int) Math.pow(2*x - 1, 2);
			temp +=  x + y;
			return temp;
		}
	}
}