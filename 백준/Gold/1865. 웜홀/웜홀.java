import java.io.*;
import java.util.*;
 
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


	public static class Node implements Comparable<Node>{
		int distance;
		int next;
		
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public Node(int next, int distance) {
			this.distance = distance;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			
			return this.distance - o.distance;
		}
		
		
	}
	
	public static ArrayList<ArrayList<Node>> route;
	public static ArrayList<ArrayList<Node>> wormhole;
	public static int P;
	public static int N;
	public static int W;
	public static int INF = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		boolean answer = false;
		
		for(int t = 0; t < T; t++) {
			route = new ArrayList<>();
			wormhole = new ArrayList<>();
			
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			P = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i <= P; i++) {
				route.add(new ArrayList<>());
				wormhole.add(new ArrayList<>());
			}
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
				
				int start = Integer.parseInt(st1.nextToken());
				int end = Integer.parseInt(st1.nextToken());
				int distance = Integer.parseInt(st1.nextToken());
				
				route.get(start).add(new Node(end,distance));
				route.get(end).add(new Node(start,distance));
				
			}
			
			for(int i = 0; i < W; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
				
				int start = Integer.parseInt(st1.nextToken());
				int end = Integer.parseInt(st1.nextToken());
				int distance = Integer.parseInt(st1.nextToken());
				
				route.get(start).add(new Node(end,-distance));
			}
			
			
			bw.write(bellmanFord() ? "YES" : "NO");
			
			if(t != T -1)bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	
	public static int[] dijkstra(int startPoint) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dp = new int[P+1];
		boolean[] visited = new boolean[P+1];
		
		Arrays.fill(dp, INF);
		
		pq.add(new Node(startPoint, 0));
		dp[startPoint] = 0;
		
		while(!pq.isEmpty()) {
			Node target = pq.poll();
			
			if(visited[target.next]) continue;
			visited[target.next] = true;
			
			for(Node next : route.get(target.next)) {
//				System.out.printf("%d , %d -> %d\n",dp[target.next] , next.distance , dp[next.next]);
				if(dp[target.next] + next.distance < dp[next.next]) {
					dp[next.next] = dp[target.next] + next.distance;
					pq.add(new Node(next.next,dp[next.next]));
				}
			}
			
		}
		
		
		return dp;
	}
	
	public static boolean bellmanFord() {
		
		int[] dp = new int[P+1];
        Arrays.fill(dp, INF);
        dp[1] = 0; 
        boolean update = false;
 
        for (int i = 1; i < P; i++) {
            update = false;
 
            for (int j = 1; j <= P; j++) {
                for (Node road : route.get(j)) {
                    if (dp[road.next] > dp[j] + road.distance) {
                        dp[road.next] = dp[j] + road.distance;
                        update = true;
                    }
                }
            }
 
            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!update) {
                break;
            }
        }
 
        // (정점의 개수 - 1)번까지 계속 업데이트가 발생했을 경우
        // (정점의 개수)번도 업데이트 발생하면 음수 사이클이 일어난 것을 의미함.
        if (update) {
            for (int i = 1; i <= P; i++) {
                for (Node road : route.get(i)) {
                    if (dp[road.next] > dp[i] + road.distance) {
                        return true;
                    }
                }
            }
        }
 
        return false;
    }
}