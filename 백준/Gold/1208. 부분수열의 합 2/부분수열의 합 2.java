import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		long[] list = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
		
		ArrayList<Long> leftSum = new ArrayList<>();
		ArrayList<Long> rightSum = new ArrayList<>();
		
		getSeqSum(leftSum, Arrays.copyOfRange(list, 0, N/2), 0, 0);
		getSeqSum(rightSum, Arrays.copyOfRange(list, N/2, N), 0, 0);
		
		leftSum.sort(null);
		rightSum.sort(null);
		
		int pl = 0;
		int pr = rightSum.size()-1;
		long answer = 0;
		
		while(pl < leftSum.size() && pr >= 0 ) {
			long tempSum = leftSum.get(pl) + rightSum.get(pr);
			if(tempSum == M) {
				
				long lCount = 0;
				long a = leftSum.get(pl);
				while (pl < leftSum.size() && leftSum.get(pl) == a) {
					lCount++;
					pl++;
				}
				
				long RCount = 0;
				long b = rightSum.get(pr);
				while(pr >= 0 && rightSum.get(pr) == b) {
					RCount++;
					pr--;
				}
				answer += lCount * RCount;


			}else if(tempSum > M) {
				pr--;
			}else {
				pl++;
			}
			
		}
		System.out.println(M == 0 ? answer - 1 :answer);
	}
	
	public static void getSeqSum(ArrayList<Long> A,long[] list, long sum, int depth) {
		if(list.length == depth) {
			A.add(sum);
			return;
		}
		getSeqSum(A,list,sum,depth+1);
		getSeqSum(A,list,sum+list[depth],depth+1);
	}
}
