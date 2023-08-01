import java.util.*;
import java.io.*;
public class Main {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static String[] dp;

	public static void main(String[] args) throws IOException{
		int num = Integer.parseInt(br.readLine());
		dp = new String[num+1];
		
		dp[0] = " ";
		dp[1] = "*";
		dp[2] = "* *";
		dp[3] = "*****";
		
		int count = dp[3].length();
		int depth = (count + 1) / 2;
		
		for(int i = 4; i <= num; i++) {
			
			dp[i] = dp[i-depth] +  repeat(dp[0],count) + dp[i-depth];
			count -= 2;
			
			if(count < 0) {
				count = dp[i].length();
				depth = (count+1)/2;
			}
		}
		
		
		for(int i = 1; i <= num;i++) {
			dp[i] = repeat(" ",num-i) + dp[i] + repeat(" ",num-i);
			bw.write(dp[i]);
			if(i != num)bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		
	}
	public static String repeat(String str,int count) {
		String temp = "";
		for(int i = 0; i < count; i++) {
			temp += str;
		}
		return temp;
	}
}


