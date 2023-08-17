import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;

	
	public static void main(String[] args) throws IOException{
		long answer = 0;
		int N = Integer.parseInt(br.readLine());
		
		int A = Integer.parseInt(br.readLine());
		int[] Aarr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int B = Integer.parseInt(br.readLine());
		int[] Barr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		ArrayList<Long> Asum = new ArrayList<>();
		ArrayList<Long> Bsum = new ArrayList<>();
		
		for(int i = 0; i < A; i++) {
			long temp = 0;
			for(int j = i ; j < A; j++) {
				temp+=Aarr[j];
				Asum.add(temp);
			}
		}
		for(int i = 0; i < B; i++) {
			long temp = 0;
			for(int j = i ; j < B; j++) {
				temp+=Barr[j];
				Bsum.add(temp);
			}
		}
		
		Asum.sort(null);
		Bsum.sort(null);

		int left = 0;
		int right = Bsum.size()-1;
		
		while(left < Asum.size() && right >= 0) {
			long sum = Asum.get(left) + Bsum.get(right);
			if(N == sum) {
				long curA = Asum.get(left);
				long Acount = 0;
				while(left < Asum.size() && curA == Asum.get(left)) {
					left++;
					Acount++;
				}
				
				long curB = Bsum.get(right);
				long Bcount = 0;
				while(right > -1 && curB == Bsum.get(right)) {
					right--;
					Bcount++;
				}
				answer += Acount * Bcount;
			}else if(N > sum) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(answer);
	}
}	
