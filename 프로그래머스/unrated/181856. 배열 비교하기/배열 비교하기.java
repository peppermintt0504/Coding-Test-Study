class Solution {
    public int solution(int[] arr1, int[] arr2) {
        if(arr1.length != arr2.length){
            if(arr1.length < arr2.length)   return -1;
            else                            return 1;
        }
        
        int sum1 = 0;
        int sum2 = 0;
        
        for(int i = 0; i < arr1.length; i++){
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        if(sum1 < sum2)   return -1;
        else if(sum1 > sum2)   return 1;
        else                            return 0;
    }
}