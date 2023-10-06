import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static char[] str;
    static final int p = 29;
    static final int MOD = 10007;
    static int Len;
    static int[] pexp = new int[200005];
    static ArrayList<Integer>[] hashTable = new ArrayList[10007];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        power();
        Len = scanner.nextInt();
        str = new char[200005];
        scanner.next().getChars(0, Len, str, 0);
        solve();
        scanner.close();
    }

    static boolean isMatach(int s1, int s2, int L) {
        for (int i = 0; i < L; i++) {
            if (str[s1 + i] != str[s2 + i]) {
                return false;
            }
        }
        return true;
    }

    static boolean find(int L) {
    	for (int i = 0; i < MOD; i++) {
            hashTable[i] = new ArrayList<>();
        }
        int hash = 0;
        for (int i = 0; i < L; i++) {
            hash = (hash * p + str[i] - 'a') % MOD;
        }
        hashTable[hash].add(0);
        for (int i = L; i < Len; i++) {
            hash = ((hash - (str[i - L] - 'a') * pexp[L - 1]) % MOD + MOD) % MOD;
            hash = (hash * p + str[i] - 'a') % MOD;
            if (!hashTable[hash].isEmpty()) {
                for (int idx : hashTable[hash]) {
                    if (isMatach(idx, i - L + 1, L)) {
                        return true;
                    }
                }
            }
            hashTable[hash].add(i - L + 1);
        }
        return false;
    }

    static void solve() {
        int l = 0, r = Len;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (find(m)) l = m;
            else r = m - 1;
        }
        System.out.println(l);
    }

    static void power() {
        pexp[0] = 1;
        for (int i = 1; i <= 200000; i++) {
            pexp[i] = (pexp[i - 1] * p) % MOD;
        }
    }
}
