import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        int[][] list = new int[n][2];
        boolean[] marked = new boolean[n]; // To mark duplicate pairs

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int gcd = gcd(a, b);
            list[i][0] = a / gcd;
            list[i][1] = b / gcd;
        }

        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (!marked[j] && list[i][0] == list[j][0] && list[i][1] == list[j][1]) {
                        marked[j] = true; // Mark as duplicate
                        ans++;
                    }
                }
            }
        }

        System.out.println((n - ans));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
