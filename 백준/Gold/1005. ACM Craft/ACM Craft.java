import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	public static void main(String[] args) throws IOException{
		int T = Integer.parseInt(br.readLine());
		
		
		while(T-->0){
			st = new StringTokenizer(br.readLine());
			
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int answer = 0;
			
			boolean[] visited = new boolean[B+1];
			
			st = new StringTokenizer(br.readLine());
			int[] times = new int[B+1];
			int[] newTimes = new int[B+1];
			for(int i = 1; i <= B; i++) {
				times[i] = Integer.parseInt(st.nextToken());
				newTimes[i] = times[i];
			}
		
			Map<Integer,ArrayList<Integer>> Nmemo = new HashMap<>();
			Map<Integer,ArrayList<Integer>> Smemo = new HashMap<>();
			for(int i = 0 ; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int need = Integer.parseInt(st.nextToken());
				
				if(!Nmemo.containsKey(need))
					Nmemo.put(need, new ArrayList<>());

				Nmemo.get(need).add(start);
				
				if(!Smemo.containsKey(start))
					Smemo.put(start, new ArrayList<>());

				Smemo.get(start).add(need);
			}
			
			int target = Integer.parseInt(br.readLine());
			int count = 0;
			
			while(count < B) {
				int temp = 0;
				ArrayList<Integer> removeList = new ArrayList<>();
				
				for(int i = 1; i <= B; i++) {
					if(visited[i] || Nmemo.containsKey(i))continue;
					temp = Math.max(temp, times[i]);
					visited[i] = true;
					count++;
					removeList.add(i);
					
					
				}
				
				for(int num : removeList) {
					if(Smemo.containsKey(num)) {
						for(int num1 : Smemo.get(num)) {
							ArrayList<Integer> tempArr = Nmemo.get(num1);
							tempArr.remove(tempArr.indexOf(num));
							if(tempArr.size() == 0) {
								Nmemo.remove(num1);
							}
							if(newTimes[num1] < newTimes[num] + times[num1]) newTimes[num1] = newTimes[num] + times[num1];
						}
					}
				}
				
				answer += temp;
				if(removeList.contains(target)) {
					bw.write(Integer.toString(newTimes[target]));
					break;
				}
			}
			
			if(T != 0)bw.write("\n");
			
		}
		bw.flush();
		bw.close();
	}
}