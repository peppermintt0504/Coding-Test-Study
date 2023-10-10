import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        String[] gears = new String[4];
        for(int i = 0 ; i < 4; i++){
            gears[i] = br.readLine();
        }

        int answer = 0 ;
        int K = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < K; t++){
            st = new StringTokenizer(br.readLine());

            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int[] turn = new int[4];

            turn[target-1] = direction;

            for(int i = target; i < 4; i++){
                if(gears[i].charAt(6) == gears[i-1].charAt(2)){
                    break;
                }else{
                    turn[i] = -turn[i-1];
                }
            }
            for(int i = target-1; i > 0; i--){
                if(gears[i].charAt(6) == gears[i-1].charAt(2)){
                    break;
                }else{
                    turn[i-1] = -turn[i];
                }
            }

            for(int i = 0 ; i < 4; i++){
                if(turn[i] == 0) continue;

                if(turn[i] == 1){
                    String temp = gears[i].substring(gears[i].length()-1,gears[i].length()).concat(gears[i].substring(0,gears[i].length()-1));
                    gears[i] = temp;
                }else{
                    String temp = gears[i].substring(1,gears[i].length()).concat(gears[i].substring(0,1));
                    gears[i] = temp;
                }
            }


        }
        for(int i = 0 ; i < 4; i++){
            String str = gears[i];
            if(str.charAt(0) == '1'){
                answer += Math.pow(2,i);
            }
//            System.out.println(str);
        }
        System.out.println(answer);
    }

}


