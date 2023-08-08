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
	public static int[] nums;
	public static boolean[] visited;
	public static ArrayList<String> check = new ArrayList<>();
	
	
	
	public static void main(String[] args) throws IOException{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		
		
		
		visited= new boolean[N];
		nums = new int[N];

		
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());

		}

		Arrays.sort(nums);
		

		
		combination(visited,"",M,0,0);
		
		
		for(int i = 0 ; i < temp.size(); i++) {
			bw.write(temp.get(i).trim());
			if(i != temp.size()-1)bw.write("\n");
		}
		
		
		bw.flush();
		bw.close();
	}
	
	public static ArrayList<String> temp = new ArrayList<>();
	public static void combination(boolean[] vistied ,String str,int target, int depth,int start) {
		if(target == depth) {
			if(!check.contains(str)) {
				temp.add(str);
				check.add(str);
			}
			return;
		}
		
		for(int i = start; i < N ;i++) {
//			if(visited[i]) continue;
			visited[i] = true;
			combination(vistied,str + " " + Integer.toString(nums[i]),target,depth+1,i);
			visited[i] = false;
		}
	}
	
	public static void permutation(boolean[] vistied ,String str,int target, int depth) {
		if(target == depth) {
			if(!check.contains(str)) {
				temp.add(str);
				check.add(str);
			}
			return;
		}
		
		for(int i = 0; i < N ;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			permutation(vistied,str + " " + Integer.toString(nums[i]),target,depth+1);
			visited[i] = false;
		}
	}

}

