import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static String[] str;
	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split("");

		int answer = 0;
		
		for(String s : str) {
			int c = s.charAt(0);
			
			if(c <= 67)answer+=3;
			else if(c <= 70)answer+=4;
			else if(c <= 73)answer+=5;
			else if(c <= 76)answer+=6;
			else if(c <= 79)answer+=7;
			else if(c <= 83)answer+=8;
			else if(c <= 86)answer+=9;
			else answer+=10;
			
		}
		System.out.println(answer);
	}

}
