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

	public static class Node{
		int val;
		Node next;
		public Node() {}
		public Node(int val) {
			this.val =val;
		}
	}
	
	public static void main(String[] args) throws IOException{
//		int T = Integer.parseInt(br.readLine());
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			Node start = new Node(Integer.parseInt(st.nextToken()));
			Node end = start;
			for(int i = 1; i < N; i++) {
				Node cur = new Node(Integer.parseInt(st.nextToken()));
				end.next = cur;
				end = cur;
			}
			
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(),"I");
			
			for(int i = 0; i < M; i++) {
				String[] commend = st.nextToken().split(" ");
				
				int index = Integer.parseInt(commend[1]);
				int C = Integer.parseInt(commend[2]);
				N += C;
				Node tempStart = new Node(Integer.parseInt(commend[3]));
				Node tempEnd = tempStart;
				
				for(int x = 4 ; x < 3 + C; x++) {
					Node temp = new Node(Integer.parseInt(commend[x]));
					tempEnd.next = temp;
					tempEnd = temp;
				}
				
				
				
				Node insertZone = start;
				
				
				if(index == 0) {
					tempEnd.next = start;
					start = tempStart;
				}else {
					for(int in = 1; in < index; in++) {
						insertZone = insertZone.next;
					}
					tempEnd.next = insertZone.next;
					insertZone.next=tempStart;
				}
				
				
			}
			
			Node point = start;
			int x = 0;
			while(10 > x) {
				sb.append(point.val + " ");
				x++;
				point = point.next;
				
			}
			
			System.out.printf("#%d %s",t,sb.toString().trim());
			if(t <T)System.out.println();
		}
		
	}
	public static int getPwd(int num) {
		while(true) {
			
		}
	}
}
//11
//449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205
//1
//I 1 5 400905 139831 966064 336948 119288