import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	public static PriorityQueue<Integer> Pqu = new PriorityQueue<>((a,b) -> {
		
		if(Math.abs(a) > Math.abs(b))
			return 1;
		else if(Math.abs(a) < Math.abs(b))
			return -1;
		else {
			if(a > b) return 1;
			else return -1;
		}
	} );
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			int num =Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(Pqu.isEmpty())
					bw.write(Integer.toString(0) + "\n");
				else
					bw.write(Integer.toString(Pqu.remove()) + "\n");
			}
			else		Pqu.add(num);
		}
		
		
		bw.flush();
		bw.close();
	}
}