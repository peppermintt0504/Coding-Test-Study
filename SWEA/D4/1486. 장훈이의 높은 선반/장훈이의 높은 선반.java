import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
    public static int[] people;
    public static int answer;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			answer = Integer.MAX_VALUE;
			people = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			getPowerSet(N,M);
			System.out.printf("#%d %d\n",t,answer-M);
		}
	}
	public static void getPowerSet(int depth, int minHeight) {
		for(int i=0; i < 1<<depth; i++) {
			int sum = 0;
	        for(int j=0; j<depth; j++) {
	            if((i & 1<<j) != 0) sum +=people[j];
	        }
            if(sum >= minHeight)answer = Math.min(answer, sum);
	    }
	}
}
