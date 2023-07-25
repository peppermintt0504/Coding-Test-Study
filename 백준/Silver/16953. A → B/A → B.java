import java.io.*;
import java.util.*;

public class Main {
    public static BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static Queue<Integer> pq = new LinkedList<>();
    public static Queue<Integer> pqCount = new LinkedList<>();
    public static Map<Integer,Boolean> visited = new HashMap<>();
    
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int answer = -1;

        pq.add(target);
        pqCount.add(0);
        while(!pq.isEmpty()){
            int n = pq.poll();
            int count = pqCount.poll();
            // System.out.printf("%d %d \n",n,count);
            if(visited.containsKey(n)) continue;

            if(n == num){
                answer = count + 1;
                break;
            }

            visited.put(n, true);

            if(n % 2 == 0){
                pq.add(n/2);
                pqCount.add(count+1);
            }else{
                if(n % 10 == 1){
                    pq.add(n / 10);
                    pqCount.add(count+1);
                }
            }
        }

        System.out.println(answer);
    }
}
