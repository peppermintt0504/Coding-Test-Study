import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		Map<Integer,String> no = new HashMap<Integer,String>();
		Map<String,Integer> name = new HashMap<String,Integer>();
		
		for(int i = 1; i <= n; i++) {
			String poketmon = br.readLine();
			no.put(i+1, poketmon);
			name.put(poketmon, i);
		}
		for(int i = 0; i < m; i++) {
			String quiz = br.readLine();
			if(quiz.toCharArray()[0] > 57) {
				bw.write(Integer.toString(name.get(quiz)));
				bw.write("\n");
			}else {
				bw.write(no.get(Integer.parseInt(quiz)+1));
				bw.write("\n");
			}
		}
		bw.flush();
		bw.close();
	}
}