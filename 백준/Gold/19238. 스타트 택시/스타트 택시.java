import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();
    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public  static int[][] map;
    public  static int[][] board;
    public  static int N;
    public  static int answer = 0;
    public static class Pos{
        int x;
        int y;
        int dist = 0;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Pos(int x, int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int F = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        Pos[] passengers = new Pos[M];
        Pos[] destination = new Pos[M];
        int[][] distance = new int[M][M];
        int[] texiDist = new int[M];


        for(int i = 0 ; i < N; i++)
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

        st = new StringTokenizer(br.readLine());
        int ty = Integer.parseInt(st.nextToken())-1;
        int tx = Integer.parseInt(st.nextToken())-1;
        Pos texi = new Pos(tx,ty);
        int min = Integer.MAX_VALUE;
        int shortest = 0;

        for(int i = 0; i < M ;i++){
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken())-1;
            int x = Integer.parseInt(st.nextToken())-1;
            int dy = Integer.parseInt(st.nextToken())-1;
            int dx = Integer.parseInt(st.nextToken())-1;
            Pos p = new Pos(x, y);
            passengers[i] = p;
            Pos d = new Pos(dx, dy);
            destination[i] = d;
        }

        Queue<Pos> qu = new LinkedList<>();
        int[][] visitied = new int[N][N];
        for(int i = 0; i < N; i++)Arrays.fill(visitied[i],Integer.MAX_VALUE);
        visitied[texi.y][texi.x]= 0;
        qu.add(texi);

        while(!qu.isEmpty()){
            Pos cur = qu.poll();

            for(int i = 0 ; i < 4; i++){
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if(mx >= N || my >= N || mx < 0 || my < 0 || visitied[my][mx] != Integer.MAX_VALUE || board[my][mx] == 1

                )continue;

                visitied[my][mx] = cur.dist+1;
                qu.add(new Pos(mx,my,cur.dist+1));

            }
        }

        for(int e = 0; e < M; e++) {
            texiDist[e] = visitied[passengers[e].y][passengers[e].x];
            if(min > texiDist[e]){
                min = texiDist[e];
                shortest = e;
            }else if(min == texiDist[e]){
                if(passengers[shortest].y > passengers[e].y){
                    min = texiDist[e];
                    shortest = e;
                }else if(passengers[shortest].y == passengers[e].y && passengers[shortest].x > passengers[e].x){
                    min = texiDist[e];
                    shortest = e;
                }
            }
        }

        for(int s = 0 ; s < M; s++){
            Pos start = destination[s];
            qu.clear();
            visitied = new int[N][N];
            for(int i = 0; i < N; i++)Arrays.fill(visitied[i],Integer.MAX_VALUE);
            visitied[start.y][start.x] = 0;
            qu.add(start);

            while(!qu.isEmpty()){
                Pos cur = qu.poll();

                for(int i = 0 ; i < 4; i++){
                    int mx = cur.x + dx[i];
                    int my = cur.y + dy[i];

                    if(mx >= N || my >= N || mx < 0 || my < 0 || visitied[my][mx] != Integer.MAX_VALUE || board[my][mx] == 1)continue;

                    visitied[my][mx] = cur.dist+1;
                    qu.add(new Pos(mx,my,cur.dist+1));

                }
            }

            for(int e = 0; e < M ; e++){
                Pos end = passengers[e];
                if(visitied[end.y][end.x] == Integer.MAX_VALUE){
                    System.out.println(-1);
                    return;
                }else
                distance[s][e] = visitied[end.y][end.x];
            }
        }

//        System.out.println(Arrays.toString(texiDist));
//        System.out.println();
//        for(int[] a : distance)
//            System.out.println(Arrays.toString(a));

        Queue<Integer> route = new LinkedList<>();
        Queue<Integer> fuel = new LinkedList<>();
        boolean[] complate = new boolean[M];
        route.add(shortest);
        fuel.add(min);

        while (!route.isEmpty()){
            int target = route.poll();
            int needFuel = fuel.poll() + distance[target][target];
            complate[target] = true;
//            System.out.println("destination : " + target + " need : " + needFuel + " curF : " + F);
            if(F - needFuel < 0){
                System.out.println(-1);
                return;
            }

            F = F - needFuel + 2*distance[target][target];

            min = Integer.MAX_VALUE;
            shortest = -1;

            for(int e = 0; e < M; e++){
                if(complate[e])continue;
                if(min > distance[target][e]){
                    min = distance[target][e];
                    shortest = e;
                }
                else if(min == distance[target][e]){
                    if(passengers[shortest].y > passengers[e].y){
                        min = distance[target][e];
                        shortest = e;
                    }else if(passengers[shortest].y == passengers[e].y && passengers[shortest].x > passengers[e].x){
                        min = distance[target][e];
                        shortest = e;
                    }
                }
            }
            if(shortest == -1)break;
            route.add(shortest);
            fuel.add(min);

        }


        System.out.println(F);
    }
}


