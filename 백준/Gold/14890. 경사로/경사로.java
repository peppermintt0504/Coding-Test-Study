import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];


        for(int i = 0; i < N; i++) board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        for(int i = 0; i < N; i++){
            boolean[][] visited = new boolean[N][N];
            boolean result = true;
            int h = 0;

            for(int x = 0; x < N - 1; x++){
                if(board[i][x] == board[i][x+1])continue;
                if(Math.abs(board[i][x] - board[i][x+1]) > 1){
                    result = false;
                    break;
                }

                boolean isPossible = true;
                if(board[i][x] < board[i][x+1]){
                    for(int n = 0 ; n < L; n++){
                        if(x-n < 0 || visited[i][x-n] || board[i][x] != board[i][x-n]) {
                            isPossible = false;
                            break;
                        }
                        visited[i][x-n] = true;
                    }

                }else{
                    for(int n = 1 ; n <= L; n++){
                        if(x+n >= N || visited[i][x+n] || board[i][x+1] != board[i][x+n]) {
                            isPossible = false;
                            break;
                        }
                        visited[i][x+n] = true;
                    }

                }

                if(!isPossible){
                    result = false;
                    break;
                }


            }
            if(result)answer++;
//            System.out.println(Arrays.toString(board[i]) + result);
        }
        for(int i = 0; i < N; i++){
            boolean result = true;
            boolean[][] visited = new boolean[N][N];
            int h = 0;

            for(int x = 0; x < N - 1; x++){
                if(board[x][i] == board[x+1][i])continue;
                if(Math.abs(board[x][i] - board[x+1][i]) > 1){
                    result = false;
                    break;
                }

                boolean isPossible = true;
                if(board[x][i] < board[x+1][i]){
                    for(int n = 0 ; n < L; n++){
                        if(x-n < 0 || visited[x-n][i] || board[x][i] != board[x-n][i]) {
                            isPossible = false;
                            break;
                        }
                        visited[x-n][i] = true;
                    }
                }else{
                    for(int n = 1 ; n <= L; n++){
                        if(x+n >= N || visited[x+n][i] || board[x+1][i] != board[x+n][i]) {
                            isPossible = false;
                            break;
                        }
                        visited[x+n][i] = true;
                    }
                }


                if(!isPossible){
                    result = false;
                    break;
                }

            }
            if(result)answer++;
//            System.out.println(Arrays.toString(board[i]) + result);
        }
        System.out.println(answer);
    }
}


