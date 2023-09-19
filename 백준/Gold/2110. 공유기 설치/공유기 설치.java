import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;
	

	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> houseList = new ArrayList<>();
		for(int i = 0; i < h; i++) {
			houseList.add(Integer.parseInt(br.readLine()));
		}
		houseList.sort(null);
		
		int left = 1;
		int right = houseList.get(h-1) - houseList.get(0) + 1;
		int mid = (left + right) / 2;

		while(left < right) {
			
			mid = (left + right) / 2;
			int index = 0;
			int count = 1;
			for(int i = 1 ; i < h; i++) {
				if(houseList.get(i) - houseList.get(index) >= mid) {
					count++;
					index = i;
				}
			}

			if(count >= r) {
				left = mid+1;
				
			}else{
				right = mid;
			}
		}
		System.out.println(left-1);
	}
}

