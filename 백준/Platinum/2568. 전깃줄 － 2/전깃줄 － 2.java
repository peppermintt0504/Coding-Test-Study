// 입력 받아서 A 전봇대 값 기준으로 오름차순 정렬하기
// B 전봇대 값으로 가장 긴 증가 수열의 거리 배열 구하기
// 방문 배열 만들고 거리 배열을 뒤에서부터 탐색해서 처음으로 나오는 거리 배열 숫자 찾아서 방문 체크
// 방문 배열에서 false값만 찾아서 false인 A 전봇대 값 sb에 추가 후 출력

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine().trim());
        StringTokenizer st;
        int[][] arrs = new int[N][2];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine().trim());
            arrs[n][0] = Integer.parseInt(st.nextToken());
            arrs[n][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrs, Comparator.comparingInt(o1 -> o1[0]));
        int[] arr = Arrays.stream(arrs).mapToInt(o -> o[1]).toArray();
        int[] D = new int[N];
        int[] result = new int[N];
        D[0] = arr[0];
        int size = 1;
        for (int i = 1; i < N; i++) {
            int index = Arrays.binarySearch(D, 0, size, arr[i]);
            index = index >= 0 ? index : Math.abs(index) - 1;
            D[index] = arr[i];
            result[i] = index;
            if (index == size) size++;
        }

        int s = size-1, i = N-1;
        boolean[] vtd = new boolean[N];
        while (s >= 0) {
            if (result[i] == s) {
                vtd[i] = true;
                s--;
            }
            i--;
        }
        int count = 0;
        for (int n = 0; n < N; n++) {
            if (!vtd[n]) {
                count++;
                sb.append(arrs[n][0]).append("\n");
            }
        }
        System.out.println(count);
        if (count > 0) {
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
    }
}