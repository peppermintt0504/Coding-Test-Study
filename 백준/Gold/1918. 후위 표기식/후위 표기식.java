import java.io.*;
import java.util.*;
 
public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static long[] dp;
	public static long c;
	public static Character[] oper1 = {'+','-'};
	public static Character[] oper2 = {'*','/'};
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		
		
		String[] bracket = {"(",")"};
		Stack<Character> stack = new Stack<>();
		
		
		for(int i = 0 ; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if('A' <= c && c <= 'Z') {
				bw.write(c);
			}else if(c == '(') {
				stack.add(c);
			}else if(c == ')') {
				while(!stack.isEmpty()) {
					char temp = stack.pop();
					if(temp == '(') {
						break;
					}
					bw.write(temp);
				}
				
			}else {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
	    			bw.write(stack.pop());
	    		}
	    		stack.add(c);
			}
		}
		while(!stack.isEmpty()) {
			bw.write(stack.pop());
	    }

		
		bw.flush();
		bw.close();
	}
	
	static int priority(char temp) {
		if(temp == '(') return 0;
		else if(Arrays.asList(oper1).contains(temp)) return 1;
		else return 2;
	}
}