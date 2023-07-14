import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public class Main {
	public static String IToS(int args){
		return Integer.toString(args);
	}
	public static int SToI(String args){
		return Integer.parseInt(args);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		
		for(int i = 0; i < n; i++) {
			int num = SToI(br.readLine());
			
			if(num == 0) {
				if(minQueue.size() == 0) {
					bw.write("0");
				}else {
					bw.write(IToS(minQueue.poll()));
				}
				bw.write("\n");
			}else {
				minQueue.add(num);
			}
		}

		bw.flush();
		bw.close();
	}
}