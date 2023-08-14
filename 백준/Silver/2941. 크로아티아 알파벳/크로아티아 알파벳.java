import java.util.*;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	public static void main(String[] args) throws IOException{
		String[] str = br.readLine().split("");
		String temp = "";
		String[] CA = {"c=", "c-","dz=", "d-", "lj", "nj", "s=" , "z="};
		
		for(int i = 0; i < str.length;i++) {
			temp += str[i];
			for(int x = 0; x < CA.length; x++) {
				if(temp.contains(CA[x])) 
					temp = temp.replace(CA[x], "@");
			}
			
			
		}
		System.out.println(temp.length());

	}
}
