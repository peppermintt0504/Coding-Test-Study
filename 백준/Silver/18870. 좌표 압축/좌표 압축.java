import java.io.*;
import java.util.*;

 
 
public class Main {
	
	public static int[] board;
	public static Map<Integer,Integer> rank; 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] numList = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] copyList = numList.clone();
		
		board = new int[N];
		rank = new HashMap<Integer,Integer>();
		
		Arrays.sort(copyList);
		
		int count = 0;
		
		for(int i = 0 ; i < N; i++) {
			if(rank.containsKey(copyList[i]))continue;
			rank.put(copyList[i], count);
			count++;
		}
		
		
		
		
		for(int i = 0; i < N; i++) {
			board[i] = rank.get(numList[i]);
		}
		
		
		for(int i = 0; i < N; i++) {
			bw.write(Integer.toString(board[i]));
			if(i != N-1)bw.write(" ");	
		}
		
		bw.flush();
		bw.close();
	}
}