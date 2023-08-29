import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] table = new int[N+1][N+1];
		int[][] answer = new int[N+1][N+1];
		
		for(int[] i : table) Arrays.fill(i, INF);
		for(int y= 0 ; y < N+1; y++) {
			for(int x = 0; x < N+1; x++) {
				answer[y][x] = x;
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			table[a][b] = distance;
			table[b][a] = distance;
		}
		
		for(int i =1; i <= N; i++) {
			for(int x = 1; x <= N; x++) {
				if(x == i)continue;
				
				for(int z = 1; z<=N; z++) {
					if(z == x || z == i || table[i][z] == INF || table[i][x] ==INF)continue;
					if(table[x][z] > table[i][x] + table[i][z]) {
						table[x][z] = table[i][x] + table[i][z];
						answer[x][z] = answer[x][i];
					}
				}
			}

		}
		
		for(int a = 1; a<=N; a++) {
			for(int b = 1; b <=N;b++) {
				if(a == b) {
					sb.append("-");
				}
				else if(answer[a][b] == INF) {
					sb.append(0);
				}else {
					sb.append(answer[a][b]);
				}
				if(b < N) sb.append(" ");
			}
			if(a < N)sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

}
