import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final int cannotCycle = 17 * 1000000 + 1;
    static final int notVisit = cannotCycle * 2;
    static int n;
    static int[][] in, dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        in = new int[n][n];
        dist = new int[n][ 1 << n ];

        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                // 0이면 갈 수 없음을 의미
                in[i][j] = sc.nextInt();
            }
            // dist 배열 초기화
            Arrays.fill(dist[i], notVisit);
        }

        dist[0][0] = 0;
        System.out.println(tsp(0, 0));
    }

    static int tsp(int now, int visited) {
        // 현재 노드 방문 처리
        visited = visited | (1<<now);

        // 모든 노드를 방문한 경우
        if(visited == (1<<n) - 1) {
            // 마지막 노드(now)에서 처음으로 갈 수 없는 경우
            if(in[now][0] == 0) {
                return cannotCycle;
            }
            // 갈 수 있는 경우 : 마지막 노드(now)에서 0으로 가는 비용 return
            return in[now][0];
        }

        // 전에 최소경로를 구해놓은 경우 : 구해놓은 최소값 return
        if(dist[now][visited] != notVisit) {
            return dist[now][visited];
        }

        for(int next = 0 ; next < n ; next ++) {
            // now에서 next로 갈 수 있는 경우
            if(in[now][next] != 0) {
                // 아직 next를 방문하지 않은 경우
                if( ( visited & (1<<next) ) == 0) {

                    // visited에 해당하는 노드들을 방문하고 현재 now에 있는 상황
                    // 이 상황에서 남은 노드들을 방문하는 최소값이
                    // now에서 next로 간 후 next에서 남은 노드들을 방문하는 최소값보다 크다면 갱신 필요
                    int temp = tsp(next, visited) + in[now][next];

                    if(dist[now][visited] > temp) {
                        dist[now][visited] = temp;
                    }
                }
            }
        }

        return dist[now][visited];
    }
}