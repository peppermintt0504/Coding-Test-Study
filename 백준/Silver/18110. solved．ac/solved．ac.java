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
		
		int count = Integer.parseInt(br.readLine());
		double sum = 0;
		int cut = (int) Math.round(count * 0.15);

		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < count; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		
		for(int i = cut; i < count-cut ; i++) {
			sum += list.get(i);
		}
		
		
		System.out.println(Math.round(sum/(count-2*cut)));
	}
}
