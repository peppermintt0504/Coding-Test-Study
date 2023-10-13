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

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        getAllCase(5,0,"");

//        cases.clear();
//        cases.add("3 2 3 2 1");

        for(String str : cases){
            board = new int[N][N];
            for(int x = 0; x < N; x++)board[x] = map[x].clone();
            int[] thisCommand = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

            for(int command : thisCommand){
                execute(command);

            }
//            System.out.println(str);
            for(int[] arr : board){
//                System.out.println(Arrays.toString(arr));
                for(int n : arr){
                    answer = Math.max(answer,n);
                }
            }
//            System.out.println();
        }
        System.out.println(answer);
    }
    public static void execute(int command){
        switch (command){
            case 0 : {
                moveToTop();
                break;
            }
            case 1 : {
                moveToRight();
                break;
            }
            case 2 : {
                moveToBottom();
                break;
            }
            case 3 : {
                moveToLeft();
                break;
            }
        }
    }

    private static void moveToLeft() {
        for(int i = 0; i < N; i++){
            int cur = 0;
            int index = 0;

            for(int j = 0; j < N; j++){
                if(board[i][j] == 0)continue;
                if(cur == 0){
                    cur += board[i][j];
                }else if(cur == board[i][j]){
                    board[i][index++] = cur*2;
                    cur = 0;
                }
                else{
                    board[i][index++] = cur;
                    cur = board[i][j];
                }
            }
            board[i][index] = cur;
            for(int x = index+1; x < N; x++){
                board[i][x] = 0;
            }
        }
    }

    private static void moveToBottom() {
        for(int i = 0; i < N; i++){
            int cur = 0;
            int index = N-1;

            for(int j = N-1; j >= 0; j--){
                if(board[j][i] == 0)continue;
                if(cur == 0){
                    cur += board[j][i];
                }else if(cur == board[j][i]){
                    board[index--][i] = cur*2;
                    cur = 0;
                }
                else{
                    board[index--][i] = cur;
                    cur = board[j][i];
                }
            }
            board[index][i] = cur;
            for(int x = index-1; x >= 0; x--){
                board[x][i] = 0;
            }
        }
    }

    private static void moveToRight() {
        for(int i = 0; i < N; i++){
            int cur = 0;
            int index = N-1;

            for(int j = N-1; j >= 0; j--){
                if(board[i][j] == 0)continue;
                if(cur == 0){
                    cur += board[i][j];
                }else if(cur == board[i][j]){
                    board[i][index--] = cur*2;
                    cur = 0;
                }
                else{
                    board[i][index--] = cur;
                    cur = board[i][j];
                }
            }

            board[i][index] = cur;
            for(int x = index-1; x >= 0; x--){
                board[i][x] = 0;
            }
        }
    }

    private static void moveToTop() {
        for(int i = 0; i < N; i++){
            int cur = 0;
            int index = 0;

            for(int j = 0; j < N; j++){
                if(board[j][i] == 0)continue;
                if(cur == 0){
                    cur += board[j][i];
                }else if (cur == board[j][i] ){
                    board[index++][i] = cur*2;
                    cur = 0;
                }
                else{
                    board[index++][i] = cur;
                    cur = board[j][i];
                }
            }

            board[index][i] = cur;
            for(int x = index+1; x < N; x++){
                board[x][i] = 0;
            }
        }
    }

    public static ArrayList<String> cases = new ArrayList<>();
    public static void getAllCase(int depth, int start, String str){
        if(depth == start){
            cases.add(str.trim());
            return;
        }

        for(int i = 0; i < 4; i++){
            getAllCase(depth,start+1,str+" " + i);
        }
    }
}


