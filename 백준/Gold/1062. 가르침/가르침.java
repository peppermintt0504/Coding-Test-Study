import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(); 
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			String word = br.readLine();
			String[] splitedWord = word.split("");
			
			ArrayList<Integer> temp = new ArrayList<>();
			boolean[] alp = new boolean[26];
			alp[0] = true;
			alp[2] = true;
			alp[8] = true;
			alp[13] = true;
			alp[19] = true;
			int count = 5;
			
			for(int x = 4; x < splitedWord.length-4; x++) {
				int code = splitedWord[x].codePointAt(0);
				if(!alp[code - 97]) {
					count++;
					alp[code - 97] = true;
					temp.add(code-97);
				}
			}
			if(count <= K)arr.add(temp);
		}
		boolean[] alp = new boolean[26];
		alp[0] = true;
		alp[2] = true;
		alp[8] = true;
		alp[13] = true;
		alp[19] = true;
		
		combination(alp, K, 5, 1);
		
		int max = 0;
		for(boolean[] b : comb) {
			int result = 0;
			ArrayList<Integer> nums = new ArrayList<>();
			for(int x = 0; x < b.length;x++) {
				if(b[x])nums.add(x);
			}
			
			for(int x = 0; x < arr.size(); x++) {
				boolean possible = true;
				
				for(int n : arr.get(x)) {
					if(!nums.contains(n)) {
						possible = false;
						break;
					}
				}
				
				if(possible) result++;
				
			}
			max = Math.max(max, result);
		}
		
		System.out.println(max);
	}
	public static ArrayList<boolean[]> comb = new ArrayList<>();
	public static void combination(boolean[] visited, int count, int depth, int start) {
		if(depth == count) {
			comb.add(visited);
			return;
		}
		
		for(int i = start; i < 26; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combination(visited.clone(),count,depth+1,i+1);
			visited[i] = false;
		}
		
	}
}	