class Solution {
    public int[] solution(int[] arr, int n) {
        int[] answer = arr;
        boolean isEven = true;
        if(arr.length % 2 == 1) isEven = false;
        
        for(int i = 0; i < arr.length; i++){
            if(i % 2 == 0 && !isEven)   answer[i] += n;
            else if(i%2 == 1 && isEven) answer[i] += n;
        }
        return answer;
    }
}