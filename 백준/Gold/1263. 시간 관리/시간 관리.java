import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] work = new int[n][n];
		
		for(int i=0;i<n;i++) 
		{
			String[] ts = br.readLine().split(" ");
			work[i][0] = Integer.parseInt(ts[0]);
			work[i][1] = Integer.parseInt(ts[1]);
		}
		
		Arrays.sort(work, (o1, o2) -> o2[1] - o1[1]);
		
		int answer = work[0][1] - work[0][0];
		
		for(int i=1;i<n;i++) 
		{
			if(work[i][1] < answer) 
			{
				answer = work[i][1];
			}
			answer -= work[i][0];
		}
		
		if(answer > 0) 
		{
			bw.write(String.valueOf(answer));
		} else 
		{
			bw.write(String.valueOf(-1));
		}
		
		bw.flush();
		bw.close();
		
	}

}