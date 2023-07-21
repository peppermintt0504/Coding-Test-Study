import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Map<String,String> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			
			String site = st1.nextToken();
			String pwd = st1.nextToken();
			
			map.put(site,pwd);
		}
		for(int i = 0 ; i < n; i++) {
			String site = br.readLine();
			String pwd = map.get(site);
			bw.write(pwd + "\n");
		}

		bw.flush();
		bw.close();
	}
}