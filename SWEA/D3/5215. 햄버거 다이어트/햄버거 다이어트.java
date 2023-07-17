import java.util.*;
import java.io.*;

class Solution
{
	public static int[] cal;
    public static int[] score;
	public static int maxCal;
	public static int answer;
	public static int[][] dp;
    
    
	public static ArrayList<ArrayList<Integer>> includesDp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++){
            
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			maxCal = input[1];
			
            cal = new int[input[0]+1];
			score = new int[input[0]+1];
            
			for(int i = 0; i < input[0]; i++) {
				int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				cal[i+1] = temp[1];
                score[i+1] = temp[0];
			}
			
            dp = new int[input[0]+1][maxCal+1];
            
			for(int i = 1; i <= input[0]; i++){
             	for(int j = 1; j <= maxCal; j++){
                	if(j < cal[i]){
                    	dp[i][j] = dp[i-1][j];
                    }else{
                    	dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cal[i]] + score[i] );
                    }

					// System.out.printf("dp[%d][%d] : %d\n",i,j,dp[i][j]);
                }
				
            }

			System.out.printf("#%d %d\n",test_case,dp[input[0]][maxCal]);
		}
    }
}