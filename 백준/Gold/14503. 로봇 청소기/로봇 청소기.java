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
        int dir;
        public Pos(int x, int y,int dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public String toString(){
            return "[ x = " + x + ", y = " + y + "]";
        }
    }


    public static void main(String[] args) throws IOException{
        int answer = 0;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        Pos init = new Pos(x,y,dir);

        for(int i = 0; i < N; i++){
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<Pos> qu = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        qu.add(init);

        while(!qu.isEmpty()){
            Pos cur = qu.poll();
            if(board[cur.y][cur.x] == 0){
                board[cur.y][cur.x] = 2;
                answer++;
            }
//            System.out.println(cur + " " + answer);
//            if(visited[cur.y][cur.x])continue;
//            visited[cur.y][cur.x] = true;

            for(int i = 1; i <= 4; i++){
                int nextDir = cur.dir - i < 0 ? 4 + (cur.dir - i) : cur.dir - i;
                int mx = cur.x + dx[nextDir];
                int my = cur.y + dy[nextDir];

                if(mx < 0 || my < 0 || mx >= M || my >= N || board[my][mx] != 0)continue;

                qu.add(new Pos(mx,my,nextDir));

                break;
            }

            if(qu.isEmpty()){
                int nextDir = cur.dir - 2 >= 0 ? cur.dir - 2 : 4 + (cur.dir - 2);
                int mx = cur.x + dx[nextDir];
                int my = cur.y + dy[nextDir];

                if(mx < 0 || my < 0 || mx >= M || my >= N || board[my][mx] == 1){

                }else
                qu.add(new Pos(mx,my,cur.dir));
            }
        }
        System.out.println(answer);

    }

}


