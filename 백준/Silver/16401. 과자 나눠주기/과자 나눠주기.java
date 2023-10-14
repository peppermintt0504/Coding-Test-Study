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
        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snake = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lo = 1;
        int hi = Arrays.stream(snake).reduce(0, Math::max) + 1;

        while(lo < hi){
            int mid = (lo + hi) / 2;
            int count = Arrays.stream(snake).reduce(0,(x,v)-> x+(int) (v/mid));
//            System.out.println(mid + "  " + count);
            if(count < M){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        System.out.println(hi-1);



    }

}