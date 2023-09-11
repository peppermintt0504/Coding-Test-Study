import java.util.*;
import java.io.*;
 
public class Main {
    static int N,M;
    static ArrayList<Integer> crane;
    static ArrayList<Integer> box;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        crane = new ArrayList<>();
        for(int i=0; i<N; i++) {
            crane.add(sc.nextInt());
        }
        M = sc.nextInt();
        box = new ArrayList<>();
        for(int i=0; i<M; i++) {
            box.add(sc.nextInt());
        }
        
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        
        if(box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }
        
        int ans = 0;
    
        while(!box.isEmpty()) {
            int idx =0;
            for(int i=0; i< N; ) {
                if(idx == box.size()) break;
                else if(crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    i++;
                }else idx++;
            }
            ans++;
        }
        
        System.out.println(ans);
                
    }
 
}