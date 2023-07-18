import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

 
 
public class Main {
	public static int[] numList;
	public static int[] sumList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		sumList = new int[temp[0]+1];
		
		for(int i = 1; i <= temp[0]; i++) {
			sumList[i] = sumList[i-1]+numList[i-1];
		}
		
		for(int testCase = 0; testCase < temp[1]; testCase++) {
			int[] temp1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int start = temp1[0];
			int end = temp1[1];
			bw.write(Integer.toString(sumList[end] - sumList[start-1]));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		
	}
}