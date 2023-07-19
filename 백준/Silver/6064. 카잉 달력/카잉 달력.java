import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
 
public class Main{
    public static void main(String[] args) throws IOException {    
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        StringTokenizer st;
 
        int num = Integer.parseInt(br.readLine());
 
          for(int i = 0; i < num; i++) {
              st = new StringTokenizer(br.readLine());
              int M = Integer.parseInt(st.nextToken());
              int N = Integer.parseInt(st.nextToken());
              int x = Integer.parseInt(st.nextToken());
              int y = Integer.parseInt(st.nextToken());
              
              // x를 먼저 맞춘다.
              int year = x;
              // 최소 공배수
              int last = LCM(N,M);
              
              while(true) {
                  // 해가 최소공배수보다 크면 -1 출력
                  if(year > last) {
                      System.out.println(-1);
                      break;
                  }
                  // year를 N으로 나머지 연산을 하면, y의 값을 알 수 있다.
                  else if(((year % N) == 0 ? N : year % N) == y){
                      System.out.println(year);
                      break;
                  }
                  // year는 M만큼 증가하고, 
                  year += M;                        
              }
          }    
    }
    
    // 최소 공배수
    public static int LCM(int A, int B) {
        
        return A * B / GCD(A,B);
    }
    // 최대 공약수 
    public static int GCD(int A, int B) {
        int temp = 0;
        while(B > 0) {
            temp = A % B;
            A = B;
            B = temp;
        }
        return A;
    }
}
