import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int testCase = 1; testCase <= T; testCase++) {

			int N = sc.nextInt(); // 손님 수 받아와
			int M = sc.nextInt(); // 몇 초에
			int K = sc.nextInt(); // 몇 개 만드는지

			int[] customer = new int[N + 1]; // 손님 idx 1부터 받을거니까

			// 손님 array에 넣어주기
			for (int i = 1; i <= N; i++) {
				customer[i] = sc.nextInt();
			}

			// 손님 오름차순 정렬
			for (int i = 1; i <= N - 1; i++) {
				int minIdx = i;
				for (int j = i + 1; j < N; j++) {
					if (customer[minIdx] > customer[j]) {
						minIdx = j;
					}
				}

				int temp = customer[minIdx];
				customer[minIdx] = customer[i];
				customer[i] = temp;
			}

			// 시간마다 가지고 있는 붕어빵 개수
			int[][] time = new int[N + 1][2];

			for (int j = 1; j <= N; j++) {
				time[j][0] = M * j; // j 분에
				time[j][1] = K * j; // 가지고 있는 붕어빵 개수
			}

			int currentTime = 0; // 
			int currentBoong = 0;
			boolean possible = true;

			while (currentTime <= customer[N]) {
				for (int i = 1; i <= N; i++) {

					if (currentTime == customer[i]) {
						currentBoong--;
					}

					if (currentTime == time[i][0]) {
						currentBoong += K;
					}

					if (currentBoong < 0) {
						possible = false;
						break;
					}

				}
				
				currentTime++;

			}

			String ans = "Possible";
			if (possible == false) {
				ans = "Impossible";
			}

			System.out.println("#" + testCase + " " + ans);

		}

	}

}
