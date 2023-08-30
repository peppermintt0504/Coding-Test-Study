import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static ArrayList<Long> list;
	
	public static class Alp implements Comparable<Alp>{
		
		long weight;
		String s;
		public Alp() {}
		public Alp(String s, long w) {
			this.s = s;
			this.weight = w;
		}
		@Override
		public int compareTo(Alp o) {
			return ((int) o.weight - (int) this.weight);
		}
	}
	public static PriorityQueue<Alp> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 9;
		int maxLen = 0;
		Map<String,Integer> memo = new HashMap<String,Integer>();
		Map<String,Long> weight = new HashMap<>();
		String[] str = new String[N];
		
		for(int n = 0; n < N; n++) {
			str[n]= br.readLine();
			maxLen = Math.max(maxLen, str[n].length());
		}
		
		String[][] list = new String[N][maxLen];
		
		for(int n = 0; n < N; n++) {
			String[] temp= str[n].split("");
			
			for(int i = 0; i < temp.length;i++) {
				list[n][temp.length - 1 -i] = temp[i];
			}
			
		}
		
		
		
		for(int x = maxLen-1; x >=0; x--) {
			for(int y = 0; y < N;y++) {
				if(list[y][x] == null)continue;
				
				if(!weight.containsKey(list[y][x])) {
					weight.put(list[y][x],(long) Math.pow(10, x));
				}else {
					weight.put(list[y][x], weight.get(list[y][x]) + (long) Math.pow(10, x));
				}
			}
		}
		

		for(Entry<String, Long> s : weight.entrySet()) {
			pq.add(new Alp(s.getKey(),s.getValue()));
		}
		

		while(!pq.isEmpty()) {
			Alp cur =pq.poll();
			memo.put(cur.s, count);
			count--;
		}
		
		int sum = 0;
		
		for(String[] s : list) {
			int temp = 0;
			int len = 0;
			for(String n : s) {
				if(n != null) {
					temp += memo.get(n)*Math.pow(10, len);
					len++;
				}
			}
			sum += temp;

		}
		
		System.out.println(sum);
	}
	
}

