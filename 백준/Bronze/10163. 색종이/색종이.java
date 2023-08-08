import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 색종이의 개수를 입력받음
        int[] count = new int[n + 1]; // 각 색종이 번호별 면적을 저장하는 배열
        int[][] arr = new int[1001][1001]; // 색종이가 차지하는 평면을 표시하는 배열

        // 색종이 정보를 입력받고, 평면에 색종이가 차지하는 부분을 표시함
        for (int i = 1; i <= n; i++) {
            int x = scanner.nextInt(); // 왼쪽 아래 x 좌표
            int y = scanner.nextInt(); // 왼쪽 아래 y 좌표
            int width = scanner.nextInt(); // 너비
            int height = scanner.nextInt(); // 높이

            // 색종이가 차지하는 영역을 해당 색종이 번호로 표시
            for (int j = x; j < x + width; j++) {
                for (int k = y; k < y + height; k++) {
                    arr[j][k] = i; // i번 색종이가 해당 위치에 존재함을 표시
                }
            }
        }

        // 각 위치별로 색종이 번호에 따라 면적을 계산하고 count 배열에 저장
        for (int i = 0; i < 1001; i++) {
            for (int j = 0; j < 1001; j++) {
                count[arr[i][j]]++; // 해당 위치에 색종이가 존재하면, 해당 색종이 번호의 면적 증가
            }
        }

        // 각 색종이 번호별 면적을 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(count[i]);
        }
    }
}