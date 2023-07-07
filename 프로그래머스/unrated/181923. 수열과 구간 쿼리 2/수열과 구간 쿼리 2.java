class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int val = queries[i][2];
            int min = 1000001;
            
            for(int j = start; j <= end; j++){
                if(arr[j] > val && min > arr[j])min = arr[j];
            }
            if(min == 1000001)answer[i] = -1;
            else answer[i] = min;
        }
        
        return answer;
    }
}