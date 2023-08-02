import java.util.*;
import java.io.*;
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	

	
	public static void main(String[] args) throws IOException{

		String str = br.readLine();
		String c4 = br.readLine();
		int len = c4.length();
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i = 0; i < str.length(); i++) {
			stack.add(str.charAt(i));
			
			if(stack.size() >= len){
				boolean flag = true;
				
				for(int z = 0; z < len;z++) {
					if(c4.charAt(z) != stack.get(stack.size() - len + z)) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					for(int z = 0; z <len; z++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c : stack) {
			sb.append(c);
		}
		
		System.out.println(sb.length() == 0 ? "FRULA" : sb);
	}
	
}


