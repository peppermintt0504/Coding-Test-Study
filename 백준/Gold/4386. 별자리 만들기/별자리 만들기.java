import java.util.*;
 
public class Main {
    
    static ArrayList<Node> startList = new ArrayList<>();
    static ArrayList<Edge>[] edgeList; 
    static boolean[] visited;
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int n = scan.nextInt();
        edgeList = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            double x = scan.nextDouble();
            double y = scan.nextDouble();
            startList.add(new Node(i, x, y));
            edgeList[i] = new ArrayList<>();
        }
        
        //모든 간선 계산
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                double dist = Math.sqrt(Math.pow(startList.get(i).x - startList.get(j).x, 2) + Math.pow(startList.get(i).y - startList.get(j).y, 2));
                edgeList[i].add(new Edge(j, dist));
                edgeList[j].add(new Edge(i, dist));
            }
        }
        
        visited = new boolean[startList.size()];
        double result = prim();
        System.out.printf("%.2f", result);
    }
    
    public static double prim() {
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.offer(new Edge(0, 0));
        double dist = 0;
        
        while(!q.isEmpty()) {
            Edge current = q.poll();
            
            if(visited[current.end] == false) {
                dist += current.cost;
                visited[current.end] = true;
            }
            else continue;        
            
            for(int i = 0; i < edgeList[current.end].size(); i++) {
                Edge next = edgeList[current.end].get(i);
                if(visited[next.end] == false) q.offer(new Edge(next.end, next.cost));
            }
        }
        return dist;
    }
    
    public static class Node {
        int num;
        double x;
        double y;
        
        public Node(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    public static class Edge implements Comparable<Edge> {
        int end;
        double cost;
        
        public Edge(int end, double cost) {
            this.end = end;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge e) {
            if(this.cost < e.cost) return -1;
            return 1;
        }
    }
}
 
