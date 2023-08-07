import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int N;
	public static int M;
	public static ArrayList<int[]> virus;
	public static ArrayList<int[]> blank;
	
	public static ArrayList<int[][]> testCase;
	
	public static void main(String[] args) throws IOException{
       
       StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
       
       N = Integer.parseInt(st1.nextToken());
       M = Integer.parseInt(st1.nextToken());
       
       int[][] board = new int[N][M];
       int[][] tempBoard = new int[N][M];
       
       int answer = 0;
       
       virus = new ArrayList<>();
       blank = new ArrayList<>();
       for(int i = 0 ; i < N; i++) {
    	   board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	   for(int j = 0 ; j < M; j++) {
    		   if(board[i][j] == 2) {
    			   int[] temp = {i,j};
    			   virus.add(temp);
    		   }else if(board[i][j] == 0) {
    			   int[] temp = {i,j};
    			   blank.add(temp);
    		   }
    	   }
       }
       
      
       
       for(int a = 0 ; a < blank.size(); a++) {
    	   for(int b = a+1 ; b < blank.size(); b++) {
    		   for(int c = b+1; c < blank.size(); c++) {
    			   for(int d = 0; d < N; d++)
    				   tempBoard[d] = board[d].clone();
    			   int[] one = blank.get(a);
    			   int[] two = blank.get(b);
    			   int[] three = blank.get(c);
    			   
    			   tempBoard[one[0]][one[1]] = 1;
    			   tempBoard[two[0]][two[1]] = 1;
    			   tempBoard[three[0]][three[1]] = 1;
    			   
    			   int result = BFS(tempBoard);
    			   
    			   if(answer < result) {
    				   answer = result;
//    				   System.out.printf("[%d,%d] [%d,%d] [%d,%d] -> %d\n",one[0],one[1],two[0],two[1],three[0],three[1],result);
    			   }
    		   }
    		   
    	   }
       }
       
       
       System.out.println(answer);
       
       
       
	}
	
	public static int BFS(int[][] TB) {
		Queue<int[]> qu = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		int[] dx = {0,1,0,-1};
		int[] dy = {-1,0,1,0};
       
		for(int[] v : virus){
			qu.add(v);
			visited[v[0]][v[1]] = true;
		}
       int count = blank.size() - 3;
       
		while(!qu.isEmpty()) {
			int[] a = qu.poll();
    	   
    	   
			for(int i = 0; i < 4; i++) {
				int x = a[1]+dx[i];
				int y = a[0]+dy[i];
    		   
				if(x < 0 || x >= M || y < 0 || y >= N || visited[y][x] || TB[y][x] != 0)continue;
    		   
				visited[a[0]][a[1]] = true;
				TB[y][x] = 2;
				int[] temp = {y,x};
				qu.add(temp);
				count--;
			}
		}
		
		return count;
	}
}

