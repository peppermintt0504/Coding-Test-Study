import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static int N;
	public static int M;
	public static int INF = 100_000_000;

	
	public static void main(String[] args) throws IOException{
       
       StringTokenizer st = new StringTokenizer(br.readLine()," ");
       
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       if(N > M) {
    	   System.out.println(N - M);
    	   return;
       }
       
       Queue<Integer> qu = new LinkedList<>();
       Queue<Integer> count = new LinkedList<>();
       
       Map<Integer,Integer> check = new HashMap<>();
       int[] visited = new int[2 * Math.max(N, M)];
       Arrays.fill(visited, INF);
       int answer = 0;
       
       qu.add(M);
       count.add(0);
       
       
       
       while(!qu.isEmpty()) {
    	   int cur = qu.poll();
    	   int curCount = count.poll();

    	   if(N == cur) {
    		   System.out.println(curCount);
    		   return;
    	   }
    	  
    	   if(cur <= 0 || cur >= visited.length ||visited[cur] < curCount)continue;
    	   else visited[cur] = curCount;
    	   
    	   if(cur % 2 == 0) {
    		   qu.add(cur/2);
    		   count.add(curCount);
    	   }
    	   qu.add(cur+1);
		   count.add(curCount+1);
		   qu.add(cur-1);
		   count.add(curCount+1);
       }

//      System.out.println(visited[N]);
  
	}
}

