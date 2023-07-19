import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Map<String,Integer> co;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			co = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				String name = st.nextToken();
				String category = st.nextToken();
				
				if(co.containsKey(category)) {
					co.put(category, co.get(category) + 1);
				}else {
					co.put(category,1);
				}
			}
			
			
			
			int answer = 1;
			
			for(String ca : co.keySet()) {
				answer *= (co.get(ca) + 1);
			}
			bw.write(Integer.toString(answer - 1) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}