import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int INF = 1_000_000_000;
    public static class Node implements Comparable<Node>{
        int next;
        int weight;

        Node(){}

        Node(int next, int weight){
            this.next = next;
            this.weight = weight;
        }

        @Override
        public int compareTo(Main.Node o) {
            
            return this.weight - o.weight;
        }
    }
    
    public static ArrayList<ArrayList<Node>> route = new ArrayList<>();
    public static int N;
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <=N; i++)
            route.add(new ArrayList<>());

        while(M-->0){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            route.get(s).add(new Node(e,d));
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start)[target]);

    }

    public static int[] dijkstra(int startPoint){
        boolean[] visited = new boolean[N+1];
        int[] dp = new int[N+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dp,INF);

        dp[startPoint] = 0;
        pq.add(new Node(startPoint,0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(visited[cur.next])continue;
            visited[cur.next] = true;

            for(Node ne : route.get(cur.next)){
                if(dp[ne.next] > dp[cur.next] + ne.weight){
                   dp[ne.next] = dp[cur.next] + ne.weight;
                   pq.add(new Node(ne.next, dp[ne.next]));
                }
            }
        }

        return dp;

    }
}
