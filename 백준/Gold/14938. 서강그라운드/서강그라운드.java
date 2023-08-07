import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int N;
	public static int M;
	public static int R;
	
	public static ArrayList<ArrayList<Area>> route = new ArrayList<>();
	public static int[] items;

	public static int INF = 100_000_000;
	
	
	public static class Area implements Comparable<Area>{
		int to;
		int distance;
		
		public Area() {
			// TODO Auto-generated constructor stub
		}

		public Area(int to, int distance) {
			super();
			this.to = to;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Area o) {
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws IOException{
       
       StringTokenizer st = new StringTokenizer(br.readLine()," ");
       
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       R = Integer.parseInt(st.nextToken());
       
       int max = 0;
       
       items = new int[N + 1];
       route.add(new ArrayList<>());
       
       st = new StringTokenizer(br.readLine()," ");
       for(int i = 1 ; i <= N; i++) {
    	   items[i] = Integer.parseInt(st.nextToken());
    	   route.add(new ArrayList<>());
    	   
       }
       
       

       for(int i = 0 ; i < R; i++) {
    	  st = new StringTokenizer(br.readLine());
    	  
    	  int spot1 = Integer.parseInt(st.nextToken());
    	  int spot2 = Integer.parseInt(st.nextToken());
    	  int distance = Integer.parseInt(st.nextToken());
    	  
    	  route.get(spot1).add(new Area(spot2,distance));
    	  route.get(spot2).add(new Area(spot1,distance));
    	  
       }
       
       
       for(int i = 1 ; i <= N ; i++) {
    	   PriorityQueue<Area> pq = new PriorityQueue<>();
    	   int[] dp = new int[N+1];
    	   boolean[] visited = new boolean[N+1]; 
    	   int result = 0;
    	   
    	   Arrays.fill(dp, INF);
           pq.add(new Area(i,0));
           dp[i] = 0;
           
           while(!pq.isEmpty()) {
        	   Area tar = pq.poll();
        	   
        	   if(visited[tar.to])	continue;
        	   else					visited[tar.to] = true;
        	   
        	   for(Area NA : route.get(tar.to)) {
        		   if(dp[NA.to] > dp[tar.to] + NA.distance) {
        			   dp[NA.to] = dp[tar.to] + NA.distance;
        			   pq.add(new Area(NA.to,dp[NA.to]));
        		   }
        	   }
        	   
           }
           
           for(int d = 1; d <= N; d++) 
        	   if(dp[d] <= M) result += items[d];
           
           if(max < result) max = result;
       }
       
       
       System.out.println(max);
      
  
	}
}

