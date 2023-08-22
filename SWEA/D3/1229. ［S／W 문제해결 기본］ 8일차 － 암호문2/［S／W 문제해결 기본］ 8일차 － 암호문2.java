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
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < M; i++) {
				String commend = st.nextToken();

				if(commend.equals("I")) {
					
					int index = Integer.parseInt(st.nextToken());
					int C = Integer.parseInt(st.nextToken());
					int[] nums = new int[C];
					
					for(int x = 0; x< C; x++) nums[x] = Integer.parseInt(st.nextToken());
					
					N += C;
					
					Node tempStart = new Node(nums[0]);
					Node tempEnd = tempStart;
					
					for(int x = 1 ; x < C; x++) {
						Node temp = new Node(nums[x]);
						tempEnd.next = temp;
						tempEnd = temp;
					}

					Node insertNode = start;
					if(index == 0) {
						tempEnd.next = start;
						start = tempStart;
					}else {
						for(int in = 1; in < index; in++) {
							insertNode = insertNode.next;
						}
						tempEnd.next = insertNode.next;
						insertNode.next=tempStart;
					}
					
				}else if(commend.equals("D")) {
					int index = Integer.parseInt(st.nextToken());
					int count = Integer.parseInt(st.nextToken());
					N -= count;
					
					
					if(index == 0) {
						for(int x = 0; x<count;x++) {
							Node temp = start.next;
							start = temp.next;
						}
					}else {
						Node cutStartNode = start;
						
						for(int in = 1; in < index; in++) cutStartNode = cutStartNode.next;
						
						for(int x = 0; x<count;x++) {
							Node temp = cutStartNode.next;
							cutStartNode.next = temp.next;
						}
						
					}
					
					
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
}