import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];

        for(int i = 0 ; i < N; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while(true){
            int[][] union = new int[N][N];
            int unionCount = 1;
            int move = 0;

            for(int i = 0 ; i < N; i++){
                for(int j = 0; j <N; j++){
                    if(union[i][j] != 0){
                        continue;
                    }
                    ArrayList<Pos> unionList = new ArrayList<>();
                    Queue<Pos> qu = new LinkedList<>();
                    int total = 0;
                    qu.add(new Pos(j,i));

                    while(!qu.isEmpty()){
                        Pos cur = qu.poll();
                        if(union[cur.y][cur.x] != 0)continue;
                        union[cur.y][cur.x] = unionCount;
                        unionList.add(cur);
                        total += board[cur.y][cur.x];

                        for(int d = 0 ; d < 4; d++){
                            int mx = cur.x + dx[d];
                            int my = cur.y + dy[d];

                            if(mx < 0 || my < 0 || mx >= N || my >= N ||
                                    Math.abs(board[cur.y][cur.x] - board[my][mx]) < L ||
                                    Math.abs(board[cur.y][cur.x] - board[my][mx]) > R
                            )continue;

                            qu.add(new Pos(mx,my));
                        }
                    }

                    unionCount++;
                    for(Pos con : unionList){
                        int afterPeople = (int) total / unionList.size();
                        if(board[con.y][con.x] != afterPeople){
                            move++;
                            board[con.y][con.x] = afterPeople;
                        }


                    }
                }
            }

//            for(int[] a : union){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println();
//            for(int[] a : board){
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println();
            if(move == 0)break;
            else answer++;
        }
        System.out.println(answer);
    }
}


