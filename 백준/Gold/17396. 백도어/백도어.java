import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static int[] dx = {0,1,0,-1};
    public static int[] dy = {-1,0,1,0};

    public static class Pos implements Comparable<Pos>{
        int to;
        long time;

        public Pos(int to,long time){
            this.to = to;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o){
            return (int) (this.time - o.time);
        }

        @Override
        public String toString() {
            return "[to :" + to + " time : " + time;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sight = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<Integer, ArrayList<Pos>> memo = new HashMap<>();

        for(int i = 0; i < N;i++)memo.put(i,new ArrayList<>());
        for(int i = 0; i < M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            memo.get(a).add(new Pos(b,t));
            memo.get(b).add(new Pos(a,t));
        }


        boolean[] visited = new boolean[N];
        long[] dp = new long[N];
        Arrays.fill(dp,Long.MAX_VALUE);
        PriorityQueue<Pos> pq = new PriorityQueue<>();

        pq.add(new Pos(0,0));
        dp[0] = 0;

        while(!pq.isEmpty()){
            Pos cur = pq.poll();

            if(visited[cur.to])continue;
            visited[cur.to] = true;


            for(Pos next : memo.get(cur.to)){
                if((sight[next.to] == 0 || next.to == N-1)&& dp[next.to] > dp[cur.to] + next.time){
                    dp[next.to] = dp[cur.to] + next.time;
                    pq.add(new Pos(next.to,dp[next.to]));
                }
            }
        }
        System.out.println(dp[N-1] == Long.MAX_VALUE ? -1 : dp[N-1]);
    }

}