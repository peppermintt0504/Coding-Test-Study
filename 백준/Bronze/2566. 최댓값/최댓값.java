import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException{

        int max = 0;
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < 9 ; i++){
            int[] board = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int n = 0; n < 9; n++){
                if(board[n] > max){
                    max = board[n];
                    x = n;
                    y = i;
                }
            }
        }
        System.out.println(max);
        System.out.printf("%d %d",y+1,x+1);
    }
}