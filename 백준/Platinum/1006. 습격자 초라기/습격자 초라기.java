import java.io.*;
import java.util.*;

public class Main {
    private static int rowCount, specialUnitCount;
    private static int[][] enemyCounts;

    private static int[] upperRowDP;
    private static int[] lowerRowDP;
    private static int[] combinedRowDP;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCaseCount; i++) {
            int minResult = Integer.MAX_VALUE;

            String[] input = reader.readLine().split(" ");

            rowCount = Integer.parseInt(input[0]);
            specialUnitCount = Integer.parseInt(input[1]);

            enemyCounts = new int[2][rowCount];

            for (int j = 0; j < 2; j++) {
                input = reader.readLine().split(" ");

                for (int k = 0; k < rowCount; k++) {
                    enemyCounts[j][k] = Integer.parseInt(input[k]);
                }
            }

            upperRowDP = new int[rowCount];
            lowerRowDP = new int[rowCount];
            combinedRowDP = new int[rowCount + 1];

            upperRowDP[0] = 1;
            lowerRowDP[0] = 1;
            combinedRowDP[0] = 0;

            solve(0);
            minResult = Math.min(minResult, combinedRowDP[rowCount]);

            if (rowCount > 1) {
                if (enemyCounts[0][0] + enemyCounts[0][rowCount - 1] <= specialUnitCount
                        && enemyCounts[1][0] + enemyCounts[1][rowCount - 1] <= specialUnitCount) {
                    upperRowDP[1] = 1;
                    lowerRowDP[1] = 1;
                    combinedRowDP[1] = 0;

                    solve(1);
                    minResult = Math.min(minResult, combinedRowDP[rowCount - 1] + 2);
                }

                if (enemyCounts[0][0] + enemyCounts[0][rowCount - 1] <= specialUnitCount) {
                    upperRowDP[1] = 2;
                    lowerRowDP[1] = enemyCounts[1][0] + enemyCounts[1][1] > specialUnitCount ? 2 : 1;
                    combinedRowDP[1] = 1;

                    solve(1);
                    minResult = Math.min(minResult, lowerRowDP[rowCount - 1] + 1);
                }

                if (enemyCounts[1][0] + enemyCounts[1][rowCount - 1] <= specialUnitCount) {
                    upperRowDP[1] = enemyCounts[0][0] + enemyCounts[0][1] > specialUnitCount ? 2 : 1;
                    lowerRowDP[1] = 2;
                    combinedRowDP[1] = 1;

                    solve(1);
                    minResult = Math.min(minResult, upperRowDP[rowCount - 1] + 1);
                }
            }

            System.out.println(minResult);
        }

        reader.close();
    }

    private static void solve(int startIndex) {
        for (int i = startIndex; i < rowCount; i++) {
            combinedRowDP[i + 1] = Math.min(upperRowDP[i] + 1, lowerRowDP[i] + 1);

            if (enemyCounts[0][i] + enemyCounts[1][i] <= specialUnitCount) {
                combinedRowDP[i + 1] = Math.min(combinedRowDP[i + 1], combinedRowDP[i] + 1);
            }

            if (i > 0 && enemyCounts[0][i - 1] + enemyCounts[0][i] <= specialUnitCount
                    && enemyCounts[1][i - 1] + enemyCounts[1][i] <= specialUnitCount) {
                combinedRowDP[i + 1] = Math.min(combinedRowDP[i + 1], combinedRowDP[i - 1] + 2);
            }

            if (i < rowCount - 1) {
                upperRowDP[i + 1] = combinedRowDP[i + 1] + 1;
                lowerRowDP[i + 1] = combinedRowDP[i + 1] + 1;

                if (enemyCounts[0][i] + enemyCounts[0][i + 1] <= specialUnitCount) {
                    upperRowDP[i + 1] = Math.min(upperRowDP[i + 1], lowerRowDP[i] + 1);
                }

                if (enemyCounts[1][i] + enemyCounts[1][i + 1] <= specialUnitCount) {
                    lowerRowDP[i + 1] = Math.min(lowerRowDP[i + 1], upperRowDP[i] + 1);
                }
            }
        }
    }
}