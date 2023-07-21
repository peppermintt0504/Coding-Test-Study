import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[] board;
	public static int[] visited;
	public static Queue<Integer> queue = new LinkedList<>();
	public static Queue<Integer> count = new LinkedList<>();
	
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int answer = 0;
		board = new int[101];
		visited = new int [101];
		
		for(int i = 1; i <= 100; i++ ) {
			board[i] = i;
		}
		
		int ladderCount = Integer.parseInt(st.nextToken());
		int snakeCount = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < ladderCount; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st1.nextToken());
			int end = Integer.parseInt(st1.nextToken());
			
			board[start] = end;
		}
		
		for(int i = 0; i < snakeCount; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st1.nextToken());
			int end = Integer.parseInt(st1.nextToken());
			
			board[start] = end;
		}
		
		
		queue.add(1);
		count.add(0);
		visited[0] = 1;
		
		while(queue.size() > 0) {
			int start = queue.remove();
			int c = count.remove();
			
//			System.out.printf("#%d : %d\n",c,start);
			
			if(start == 100) {
				answer = c;
				break;
			}
			
			for(int i = 1; i <= 6; i++) {
				if( start + i > 100 || visited[start+i] == 1) continue;
				visited[start+i] = 1;
				queue.add(board[start+i]);
				count.add(c+1);
			}
		}
		
		System.out.println(answer);
		bw.flush();
		bw.close();
	}
}