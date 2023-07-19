import java.io.*;
import java.util.*;
 
public class Main {
 
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static Queue<Integer> qu;
	public static Queue<String> strQu;
	public static Map<Integer,Boolean> map;
	
	public static void main(String[] args) throws IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			map = new HashMap<>();
			qu= new LinkedList<Integer>(); 
			strQu= new LinkedList<String>(); 
			
			qu.add(num);
			strQu.add("");
			map.put(num, true);
			
			while(qu.size() > 0) {
				int n = qu.poll();
				String str = strQu.poll();
				
				if(n == target) {
					bw.write(str+"\n");
					break;
				}
				
				int Dn = D(n); 
				int Sn = S(n);
				int Ln = L(n);
				int Rn = R(n);
				
//				System.out.printf("%d %d %d %d \n",Dn,Sn,Ln,Rn);
				
				if(!map.containsKey(Dn)) {
					map.put(Dn,true);
					strQu.add(str + "D");
					qu.add(Dn);
				}
				if(!map.containsKey(Sn)) {
					map.put(Sn,true);
					strQu.add(str + "S");
					qu.add(Sn);
				}
				if(!map.containsKey(Ln)) {
					map.put(Ln,true);
					strQu.add(str + "L");
					qu.add(Ln);
				}
				if(!map.containsKey(Rn)) {
					map.put(Rn,true);
					strQu.add(str + "R");
					qu.add(Rn);
				}
			}
			
		}
		
		bw.flush();
		bw.close();
	}
	public static int D(int num) {
		
		return  (2*num) % 10000;
	}
	public static int S(int num) {
		return num == 0 ? 9999 : num - 1;
	}
	public static int L(int num) {
		return (num%1000) * 10 + num / 1000;
	}
	public static int R(int num) {
		return (num / 10) + (num % 10) * 1000;
	}
}