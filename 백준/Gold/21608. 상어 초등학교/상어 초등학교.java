import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static class Pos{
        int x;
        int y;

        public Pos(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[][] board = new int[N][N];
        Map<Integer,ArrayList<Integer>> properList = new HashMap<>();


        for(int t = 0 ; t < N*N; t++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> proper = new ArrayList<>();
            properList.put(num,proper);
            int[][][] tempBoard = new int[N][N][2];

            int max = 0;
            ArrayList<Pos> list = new ArrayList<>();


            for(int i = 0; i < 4; i++) proper.add(Integer.parseInt(st.nextToken()));

            for(int y = 0; y < N; y++){
                for(int x = 0; x < N; x++){
                    if(board[y][x] != 0)continue;

                    int score = 0;
                    int secondScore = 0;

                    for(int i = 0; i < 4; i++){
                        int mx = x + dx[i];
                        int my = y + dy[i];

                        if(mx < 0 || my < 0 || mx >= N || my >= N) continue;

                        if(proper.contains(board[my][mx])){
                            score++;
                        }
                        if(board[my][mx] == 0){
                            secondScore++;
                        }
                    }

                    tempBoard[y][x][0] = score;
                    if(score > max){
                        max = score;
                        list.clear();
                        list.add(new Pos(x,y));
                    } else if (score == max) {
                        list.add(new Pos(x,y));
                    }
                    tempBoard[y][x][1] = secondScore;
                }
            }

            if(list.size() == 1){
                Pos position = list.get(0);

                board[position.y][position.x] = num;
                continue;
            }

            max = 0;
            ArrayList<Pos> secondList = new ArrayList<>();

            for(Pos p : list){
                if(max < tempBoard[p.y][p.x][1]){
                    max = tempBoard[p.y][p.x][1];
                    secondList.clear();
                    secondList.add(p);
                } else if (max == tempBoard[p.y][p.x][1]) {
                    secondList.add(p);
                }
            }

            if(secondList.size() == 1){
                Pos position = secondList.get(0);
                board[position.y][position.x] = num;
                continue;
            }

            int min = Integer.MAX_VALUE;
            list.clear();

            for(Pos p : secondList){
                if(p.y < min){
                    min = p.y;
                    list.clear();
                    list.add(p);
                } else if (p.y == min) {
                    list.add(p);
                }
            }

            if(list.size() == 1){
                Pos position = list.get(0);

                board[position.y][position.x] = num;
                continue;
            }


            min = Integer.MAX_VALUE;
            secondList.clear();

            for(Pos p : list){
                if(p.x < min){
                    min = p.x;
                    secondList.clear();
                    secondList.add(p);
                } else if (p.x == min) {
                    secondList.add(p);
                }
            }

            Pos position = secondList.get(0);

            board[position.y][position.x] = num;

        }
        for(int y = 0; y < N; y++){
            for(int x = 0; x < N; x++){
                int score = 0;


                for(int i = 0; i < 4; i++){
                    int mx = x + dx[i];
                    int my = y + dy[i];

                    if(mx < 0 || my < 0 || mx >= N || my >= N) continue;

                    if(properList.get(board[y][x]).contains(board[my][mx])){
                        score++;
                    }
                }

                if(score == 1){
                    answer += 1;
                } else if (score == 2) {
                    answer += 10;
                } else if (score == 3) {
                    answer += 100;
                }else if (score == 4){
                    answer += 1000;
                }

            }
        }

        System.out.println(answer);
    }

}