import java.util.Scanner;

public class Main {
	static int W, H; // 너비, 높이
	static int[][] map; // 2차원 배열
	static boolean[][] visited;


	// 8방 탐색
	static int[] dr = { -1, 1, 0, 0, 1, 1, -1, -1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();

			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			visited = new boolean[H][W]; 

			// 2차원 배열 입력 받기
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					map[r][c] = sc.nextInt();

				}
			}

			int cnt = 0; // 섬의 개수

			// 2차원 배열을 행 우선 순회하면서
			// 방문하지 않은 1을 만난 경우.
			// 그 (r, c)부터 DFS탐색을 시작
			for (int r = 0; r < H; r++) {
				for (int c = 0; c < W; c++) {
					if (map[r][c] == 1 && !visited[r][c]) {
						visited[r][c] = true; // 시작점을 방문처리 후
						dfs(r, c); // 시작점부터 탐색 시작					
						cnt++; // 새로운 그래프를 발견했으므로.
					}
				}
			}
            
			System.out.println(cnt);
			cnt = 0; 
		}
		
	}

	private static void dfs(int r, int c) {
		// 현재 정점 (r, c)
		// 이웃한 정점 중에서 아직 방문하지 않은 곳이 있다면
		// 그 정점으로 탐색을 계속 해 나가면 됨(재귀)
		// 재귀 -> 스택 -> dfs

		// 이웃한 정점 : 후보 8개 -> 2차원 배열 범위 안 -> 1인 곳
		// & 방문하지 않은 경우


		for (int d = 0; d < 8; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 1 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc); // 시작점부터 탐색 시작

			}
		}
		


	}

	

	

}
