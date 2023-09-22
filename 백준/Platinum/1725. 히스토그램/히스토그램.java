import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int INF = Integer.MAX_VALUE;

	static class Pos{
		int start;
		int height;
		
		public Pos() {}
		public Pos(int start, int height) {
			this.start = start;
			this.height = height;
		}
		@Override
		public String toString() {
			return "Start :" + start + "  Height :" + height;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] histo = new int[N];
		ArrayDeque<Pos> dq = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			histo[i] = Integer.parseInt(br.readLine());
		}
		
		dq.push(new Pos(0,histo[0]));
		for(int i = 1 ; i < N; i++) {
//			System.out.println("i : " + i + " h : " + histo[i] + " --- " +dq.getFirst() );
			if(histo[i] > dq.getFirst().height) {
				dq.push(new Pos(i,histo[i]));
			}else if(histo[i] < dq.getFirst().height) {
				int index = 0;
				
				while(!dq.isEmpty() && dq.getFirst().height > histo[i]) {
					Pos cur = dq.pop();
					int area = (i - cur.start) * cur.height;
					answer =Math.max(answer,area);
					index = cur.start;
//					System.out.println("!!! " + cur + "    " + area);
				}
//				System.out.println(index + "  " + histo[i] + "  " + dq.getFirst().height);
				if(dq.isEmpty()) {
					dq.push(new Pos(index,histo[i]));
				}else if(dq.getFirst().height != histo[i]) {
//					System.out.println("!@#!@#");
					dq.push(new Pos(index,histo[i]));
				}
			}
			
		}
		int index = N;
		while(!dq.isEmpty()) {
			Pos cur = dq.pop();
			int area = (index - cur.start) * cur.height;
			answer =Math.max(answer,area);
//			System.out.println("!!!@! " + cur + "    " + area);
		}
		
		System.out.println(answer);
	}
}

//8
//4
//7
//6
//8
//5
//9
//1
//0


