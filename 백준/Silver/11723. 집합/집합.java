import java.io.*;
import java.util.*;

 
 
public class Main {
	public static ArrayList<Integer> set;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		set = new ArrayList<>();
		
		for(int testCase = 0; testCase < N; testCase++) {
			String[] temp = br.readLine().split(" ");
			String command = temp[0];
			
			if(command.equals("add")) {
				addSet(Integer.parseInt(temp[1]));
			}
			else if(command.equals("remove")) {
				remove(Integer.parseInt(temp[1]));
			}
			else if(command.equals("check")) {
				bw.write(Integer.toString(check(Integer.parseInt(temp[1]))));
				bw.write("\n");
			}
			else if(command.equals("toggle")) {
				toggle(Integer.parseInt(temp[1]));
			}
			else if(command.equals("all")) {
				all();
			}
			else if(command.equals("empty")) {
				empty();
			}
		}
		
		
		
		
		bw.flush();
		bw.close();
		
	}
	
	public static void addSet(int num) {
		if(!set.contains(num))
			set.add(num);
	}
	public static void remove(int num) {
		if(set.contains(num))
			set.remove(set.indexOf(num));
	}
	public static int check(int num) {
		if(set.contains(num))
			return 1;
		else return 0;
	}
	public static void toggle(int num) {
		if(set.contains(num))
			set.remove(set.indexOf(num));
		else
			set.add(num);
	}
	public static void all() {
		set = new ArrayList<>();
		for(int i = 1; i <= 20; i++)
			set.add(i);
	}
	public static void empty() {
		set = new ArrayList<>();
	}
}