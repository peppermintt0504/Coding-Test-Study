import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int[] visited;
	public static int num;
	public static int answer = 0;
	
	public static void main(String[] args) throws IOException{
		num = Integer.parseInt(br.readLine());

		visited = new int[num+1];
		

		BFS(1);
		
		System.out.println(answer);
		
	}
	public static void BFS(int depth) {
		if(depth == 1) {
			for(int i = 1 ; i <= num; i++) {
				visited[1] = i;
				BFS(2);
			}
		}else if(depth == num+1) {
			answer++;
//			System.out.println(Arrays.toString(visited));
		}
		else {
			
			for(int i = 1; i <=num;i++) {
				boolean can =true;
				for(int j = 1; j < depth;j++){
					if(visited[j] == i || visited[j] + (depth-j) == i || visited[j] - (depth - j) == i) {
						can= false;
						break;
					}
				}
				if(can) {
					visited[depth] = i;
					BFS(depth+1);
				}
			}
		}
	}
}


