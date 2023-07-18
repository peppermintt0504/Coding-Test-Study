import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		int S = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String stand = "";
		
		int answer = 0;
		
		for(int i = 0; i < 2*N + 1; i++) {
			if(i%2 == 0)stand += "I";
		else			stand += "O";
		}
		
		for(int i = 0; i <= S - (2*N + 1);i++) {
			if(str.substring(i,i+(2*N + 1)).equals(stand))answer++;
		}
		
		System.out.println(answer);
	}
}