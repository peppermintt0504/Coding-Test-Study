import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int[] dx = {0,1,-1,0,0};
    public static int[] dy = {0,0,0,-1,1};


    public static class Pos{
        int x;
        int y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "[ x = " + x + ", y = " + y + "]";
        }
    }


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int initY = Integer.parseInt(st.nextToken());
        int initX = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Pos cur = new Pos(initX,initY);

        int[][] board = new int[N][M];
        for(int i = 0 ; i < N; i++)
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] side = new int[4];
        int bottom = 0;
        int top = 0;

        int[] commands = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int command : commands){
            int mx = cur.x + dx[command];
            int my = cur.y + dy[command];
//            System.out.println(mx + ", " + my);

            if(mx < 0 || my < 0 || mx >=M || my >= N)continue;

            switch (command){
                case 1:{
                    int temp = bottom;

                    if(board[my][mx] == 0) {
                        board[my][mx] = side[1];
                        bottom = side[1];
                    }
                    else {
                        bottom = board[my][mx];
                        board[my][mx] = 0;
                    }
                    side[1] = top;
                    top = side[3];
                    side[3] = temp;

                    break;
                }
                case 2:{
                    int temp = bottom;

                    if(board[my][mx] == 0) {
                        board[my][mx] = side[3];
                        bottom = side[3];
                    }
                    else {
                        bottom = board[my][mx];
                        board[my][mx] = 0;
                    }
                    side[3] = top;
                    top = side[1];
                    side[1] = temp;

                    break;
                }
                case 3:{
                    int temp = bottom;

                    if(board[my][mx] == 0){
                        board[my][mx] = side[0];
                        bottom = side[0];
                    }
                    else {
                        bottom = board[my][mx];
                        board[my][mx] = 0;
                    }
                    side[0] = top;
                    top = side[2];
                    side[2] = temp;

                    break;
                }
                case 4:{
                    int temp = bottom;

                    if(board[my][mx] == 0){
                        board[my][mx] = side[2];
                        bottom = side[2];
                    }
                    else {
                        bottom = board[my][mx];
                        board[my][mx] = 0;
                    }
                    side[2] = top;
                    top = side[0];
                    side[0] = temp;

                    break;


                }
            }

            cur.x = mx;
            cur.y = my;
//            for(int[] s : board){
//                System.out.println(Arrays.toString(s));
//            }
            System.out.println(top);
//            System.out.println(Arrays.toString(side));
//            System.out.println(bottom);
//            System.out.println();
        }

    }

}


