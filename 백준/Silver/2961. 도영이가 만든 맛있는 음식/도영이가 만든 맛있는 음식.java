import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static class Ingredient{
		int sour;
		int salty;
		
		public Ingredient() {}
		public Ingredient(int sour, int salty) {
			this.salty = salty;
			this.sour = sour;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int answer = Integer.MAX_VALUE;
		ArrayList<Ingredient> list = new ArrayList<>();
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int sour = Integer.parseInt(st.nextToken());
			int salty = Integer.parseInt(st.nextToken());
			
			list.add(new Ingredient(sour,salty));
		}
		
		
		for(int i = 1; i < 1 <<(N); i++) {
			int[] temp = Arrays.stream(Integer.toBinaryString(i).split("")).mapToInt(Integer::parseInt).toArray();
			boolean[] check = new boolean[N];
			
			int totalSour = 1;
			int totalSalty = 0;
			
			for(int x = 0; x < temp.length; x++) {
				check[temp.length - 1 - x] = temp[x] == 1 ? true: false;
			}
			
			
			for(int x = 0; x < check.length;x++) {
				if(check[x]) {
					totalSour *= list.get(x).sour;
					totalSalty += list.get(x).salty;
				}
			}
			answer = Math.min(answer, Math.abs(totalSalty - totalSour));
		}
		
		System.out.println(answer);
	}
}	