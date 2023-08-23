
import java.util.Scanner;

public class Solution {
	public static void main(String[] args)  {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {
			int N = sc.nextInt(); // puzzle의 크기
			int K = sc.nextInt(); // 단어의 길이

			int[][] arr = new int[N][N];

			// 값 넣기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int[][] rowArr = new int[N][N];
			int[][] colArr = new int[N][N];
			int ans = 0;

			// 가로탐색
			for (int i = 0; i < N; i++) {
				int nextNum = arr[i][0];
				for (int j = 1; j < N; j++) {
					if (arr[i][j] == 0) {
						nextNum = 0;
					}
					nextNum += arr[i][j];
					rowArr[i][j] = nextNum;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (rowArr[i][j] == K) {
						ans++;
					} else if (rowArr[i][j] == K + 1) {
						ans--;
					}
				}
			}

			// 세로탐색
			for (int j = 0; j < N; j++) {
				int nextNum = arr[0][j];
				for (int i = 1; i < N; i++) {
					if (arr[i][j] == 0) {
						nextNum = 0;
					}
					nextNum += arr[i][j];
					colArr[i][j] = nextNum;
				}
			}

			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (colArr[i][j] == K) {
						ans++;
					} else if (colArr[i][j] == K + 1) {
						ans--;
					}
				}
			}
			
			System.out.println("#" + testCase + " " + ans);

		}
	}
}
