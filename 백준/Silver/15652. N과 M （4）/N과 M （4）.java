import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static int N;
	public static int M;
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		boolean[] visited= new boolean[N];

		

		combination("",M,0,0);
		
		
		for(String str : temp)
			System.out.println(str.trim());

		
		
		bw.flush();
		bw.close();
	}
	
	public static ArrayList<String> temp = new ArrayList<>();
	public static void combination(String str,int target, int depth,int start) {
		if(target == depth) {
			temp.add(str);
			return;
		}
		
		for(int i = start; i < N ;i++) {
			combination(str + " " + Integer.toString(i + 1),target,depth+1,i);
		}
	}

}

