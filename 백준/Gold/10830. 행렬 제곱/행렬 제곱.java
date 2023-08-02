import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        long square = Long.parseLong(tokenizer.nextToken());

        int[][] matrix = new int[n][n];
        int[][] odd = new int[n][n];
        boolean isOddEmpty = true;

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(input.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        // 더 이상 짝지어 곱해줄 행렬이 남지 않을때까지
        while (square > 1) {
            // 만약 홀수라면
            if (square % 2 == 1) {
                // odd 가 없을때는 그냥 저장
                if (isOddEmpty) {
                    odd = matrix;
                    isOddEmpty = false;
                } 
                // odd 가 이미 존재한다면 곱해준 다음 저장
                else {
                    odd = multiple(matrix, odd, n);
                }
            }
            // 계속 제곱해주고
            matrix = multiple(matrix, matrix, n);
            // 제곱수는  /2
            square /= 2;
        }

        if (isOddEmpty) {
            printMatrix(matrix, n, output);
        } else {
            matrix = multiple(matrix, odd, n);
            printMatrix(matrix, n, output);
        }

        output.flush();
        output.close();
        input.close();
    }
    
    // 행렬 곱셈 메소드
    public static int[][] multiple(int[][] matrix_01, int[][] matrix_02, int n) {
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += matrix_01[i][k] * matrix_02[k][j];
                    result[i][j] %= 10000;
                }
            }
        }

        return result;
    }

    // 마지막 결과값 출력 메소드
    public static void printMatrix(int[][] matrix, int n, BufferedWriter output) throws IOException {
        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                output.write(matrix[i][j] % 1000 + " ");
            }
            output.write("\n");
        }
    }
}