import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;


public class Main {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	public static StringBuilder sb = new StringBuilder();
	public static int INF = 100_000_000;

	public static ArrayList<Integer> preorder = new ArrayList<>();
	public static int[] inorder;
	public static int[] postorder;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		
		inorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		postorder = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		getPreorder(0,N-1,0,N-1);
		for(int i = 0 ; i < N;i++) {
			sb.append(preorder.get(i) + " ");
		}
		System.out.println(sb.toString());
	}
	
	public static void getPreorder(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart>inEnd || postStart > postEnd)return;
		
		int root = postorder[postEnd];
		int index = 0;
		for(int i = 0 ; i < inorder.length;i++) {
			if(root == inorder[i])index = i;
		}

		preorder.add(root);
		getPreorder(inStart, index - 1, postStart, postStart + index - inStart - 1);
		getPreorder(index + 1, inEnd, postStart + index - inStart, postEnd - 1);
		
	}
	
}	
