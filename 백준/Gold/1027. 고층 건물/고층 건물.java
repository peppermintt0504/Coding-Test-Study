import java.io.*;
import java.util.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[] buildings = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int answer = 0;
		for(int i = 0; i < N; i++) {
			int target = buildings[i];
			double inclination = -1000000001;
			int count = 0;
			for(int x = 1 ; x + i < N; x++) {
				double temp = (double)(target - buildings[i+x]) / (i - (i + x));
				if(inclination < temp) {
					count ++;
					inclination = temp;
				}
			}
			inclination = Double.MAX_VALUE;
			for(int x = i-1 ; x >= 0; x--) {
				double temp = (double)(target - buildings[x]) / (i - x);
				
				if(inclination > temp) {
					count ++;
					inclination = temp;
				}
			}
			answer =Math.max(answer, count);
		}
		System.out.println(answer);
	}

}
