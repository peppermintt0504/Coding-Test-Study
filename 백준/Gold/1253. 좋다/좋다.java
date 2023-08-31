import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static int INF = Integer.MAX_VALUE;
	

	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());

        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        
        int answer =0;
        
        
        
        for(int i = 0; i < N; i++) {
        	int target = i;
        	int left= 0;
            int right = N - 1;
            
        	while(left < right) {
        		if(left == i) {
        			left++;
        			continue;
        		}
        		if(right == i) {
        			right--;
        			continue;
        		}
        		
        		if(nums[left] + nums[right] > nums[target])right--;
        		else if(nums[left] + nums[right] < nums[target]) left++;
        		else {
        			answer++;
        			break;
        		}
        	}
        	
        }
        System.out.println(answer);
	}
   
}

