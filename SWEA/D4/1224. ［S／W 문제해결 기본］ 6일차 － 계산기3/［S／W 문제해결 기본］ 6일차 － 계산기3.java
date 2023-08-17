import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Solution {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;
	public static int[] dx = {0,1,0,-1};
	public static int[] dy = {-1,0,1,0};

	
	public static void main(String[] args) throws IOException{
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			Stack<Character> stack = new Stack<>();
			Queue<Character> qu = new LinkedList<>();
			
			for(int i = 0 ; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if('0' <= c && c <= '9') {
					qu.add(c);
				}else if(c == '(') {
					stack.add(c);
				}else if(c == ')') {
					while(!stack.isEmpty()) {
						char temp = stack.pop();
						if(temp == '(') {
							break;
						}
						sb.append(temp);
						qu.add(temp);
					}
					
				}else {
					while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
						char te = stack.pop();
						sb.append(te);
						qu.add(te);
		    		}
		    		stack.add(c);
				}
			}
			while(!stack.isEmpty()) {
				char te = stack.pop();
				sb.append(te);
				qu.add(te);
		    }

			
			Stack<Integer> numStack = new Stack<>();
			while(!qu.isEmpty()) {
				char cur = qu.poll();
				if('0' <= cur && cur <= '9') {
					numStack.push(cur - '0');
				}else {
					int a = numStack.pop();
					int b = numStack.pop();
					
					if(cur == '*') {
						numStack.push(a*b);
					}else if(cur == '+') {
						numStack.push(a+b);
					}
				}
			}
			
			System.out.printf("#%d %s",t,numStack.pop());
			if(t <T)System.out.println();
		}
		
	}
	static int priority(char temp) {
		Character[] bracket = {'(',')'};
		Character[] oper1 = {'+','-'};
		if(Arrays.asList(bracket).contains(temp)) return 0;
		else if(Arrays.asList(oper1).contains(temp)) return 1;
		else return 2;
	}
}
