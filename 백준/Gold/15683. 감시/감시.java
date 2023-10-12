import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static ArrayList<CCTV> cctvList;
    public static int[][][] directionCase = {
            {},
            {{0},{1},{2},{3}},
            {{0,2},{1,3}},
            {{0,1},{1,2},{2,3},{3,0}},
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},
            {{0,1,2,3}}
    };

    public static class CCTV{
        int x;
        int y;
        int type;
        public CCTV(int x,int y,int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }

    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = Integer.MAX_VALUE;

        int[][] board = new int[N][M];
        cctvList = new ArrayList<>();

        for(int i = 0 ; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < M; j++){
                if(board[i][j] > 0 && board[i][j] < 6){
                    cctvList.add(new CCTV(j,i,board[i][j]));
                }
            }
        }
        getAllCase(0,cctvList.size(),new ArrayList<>());

        for(int t = 0; t < cases.size(); t++){
//            System.out.println("Test " + (t+1));
            ArrayList<int[]> thisCase = cases.get(t);

            int[][] tempBoard = new int[N][M];
            for(int x = 0; x < N;x++)
                tempBoard[x] = board[x].clone();

            for(int i = 0 ; i < cctvList.size(); i++){
                CCTV cur = cctvList.get(i);
                int[] dir = thisCase.get(i);

                for(int d : dir){
                    int mx = cur.x + dx[d];
                    int my = cur.y + dy[d];

                    while( mx >= 0 && mx < M && my >= 0 && my < N && tempBoard[my][mx] < 6){
                        tempBoard[my][mx] = -1;
                        mx += dx[d];
                        my += dy[d];
                    }
                }
            }

            int count = 0;
            for(int[] x : tempBoard){
//                System.out.println(Arrays.toString(x));
                for(int y : x){
                    if(y == 0) count++;
                }
            }
            answer = Math.min(answer,count);
        }
        System.out.println(answer);
    }

    public static ArrayList<ArrayList<int[]>> cases = new ArrayList<>();

    public static void getAllCase(int start, int depth,ArrayList<int[]> arr){
        if(start == depth){
            cases.add(arr);
//            for(int[] aaa : arr){
//                System.out.println(Arrays.toString(aaa));
//            }
            return;
        }
        for(int[] a : directionCase[cctvList.get(start).type]){
            ArrayList<int[]> temp = (ArrayList<int[]>) arr.clone();
            temp.add(a);

            getAllCase(start+1,depth,temp);
        }
    }
}


