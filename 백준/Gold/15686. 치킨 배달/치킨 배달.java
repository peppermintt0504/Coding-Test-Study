import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	public static int[][] board;
	public static int[][] distance;
	public static int N;
	public static int M;
	public static int count = 0;
	public static ArrayList<Pos> chickenHouse = new ArrayList<>();
	public static ArrayList<Pos> house = new ArrayList<>();
	
	public static class Pos{
		int x;
		int y;
		public Pos() {
			// TODO Auto-generated constructor stub
		}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString(){
			return "[" + Integer.toString(this.x) + ", " + Integer.toString(this.y) + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
		
		
		for(int i = 0; i < N; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			for(int j= 0 ; j < N; j++) {
				if(board[i][j] == 2) chickenHouse.add(new Pos(j,i));
				else if(board[i][j] == 1) house.add(new Pos(j,i));
			}
		}
		
		
		distance = new int[house.size()][chickenHouse.size()];
		

		for(int i = 0; i < house.size(); i++) {
			Pos curHouse = house.get(i);
			
			for(int j = 0; j < chickenHouse.size(); j++) {
				Pos curCH = chickenHouse.get(j);
				distance[i][j] = Math.abs(curHouse.x - curCH.x) + Math.abs(curHouse.y - curCH.y);
			}
			
		}
		
		boolean[] visited = new boolean[chickenHouse.size()];
		
		

		combination(visited,0,M,0);
		int answer = 10000;
		for(int i = 0; i < temp.size();i++) {
			int result = 0;
			for(int j = 0; j < house.size();j++) {
				int min = 10000;
				
				
				
				for(int x = 0 ; x < chickenHouse.size() ;x++) {
					if(temp.get(i)[x])
						min = Math.min(min, distance[j][x]);
				}
				result += min;
			}
			

			if(answer > result)answer = result;
			
		}
		System.out.println(answer);
	}
	
	public static ArrayList<boolean[]> temp = new ArrayList<>();
	public static void combination(boolean[] visited,int depth, int target, int start) {
		if(depth == target) {
			temp.add(visited.clone());
			return;
		}
		
		for(int i = start ; i < visited.length;i++){
			if(visited[i])continue;
			visited[i] = true;
			combination(visited,depth+1,target,i+1);
			visited[i] = false;
		}
		
	}
}

