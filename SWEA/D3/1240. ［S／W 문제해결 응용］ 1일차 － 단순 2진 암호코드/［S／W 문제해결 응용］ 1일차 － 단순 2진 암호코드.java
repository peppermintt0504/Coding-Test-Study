import java.io.*;
import java.util.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		String[] numList = {"0001101", "0011001", "0010011", "0111101", "0100011","0110001","0101111","0111011","0110111","0001011"};
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int answer = 0;
			boolean hasCode = false;
			int codeEndPosition = 0;
			int[] sample = new int[M];
			int odd = 0;
			int even = 0;
			for(int i = 0; i < N; i++) {
				int[] nums = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
				
				if(hasCode) continue;
				for(int x = 0; x < M; x++) {
					if(nums[M - 1 - x] == 1) {
						hasCode = true;
						codeEndPosition = M - 1 - x;
						sample = nums.clone();
						break;
					}
				}
			}
//			System.out.println(codeEndPosition);
			int count = 1;
			for(int x = codeEndPosition - 55; x <= codeEndPosition; x+=7) {
				String str = "";
				
				for(int g = 0; g < 7; g++) {
					str += Integer.toString(sample[x+g]);
				}
				for(int a = 0; a < 10; a++) {
					if(str.equals(numList[a])) {
//						System.out.println(a);
						if(count%2 == 0)even +=a;
						else		odd += a;
						count++;
						answer+= a;
					}
				}
			}
//			System.out.println(even);
			if((odd*3+even)%10 == 0) {
				System.out.printf("#%d %d\n",t,answer);
			}
			else {
				System.out.printf("#%d %d\n",t,0);
			}
			
		}
	}
}
