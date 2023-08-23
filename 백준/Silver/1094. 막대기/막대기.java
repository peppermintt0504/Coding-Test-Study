import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] Nums = Arrays.stream(Integer.toBinaryString(N).split("")).mapToInt(Integer::parseInt).toArray();
		
		int answer = Arrays.stream(Nums).reduce(0, (a,b)->{
			return a+b;
		});
		
		System.out.println(answer);
	}
}	