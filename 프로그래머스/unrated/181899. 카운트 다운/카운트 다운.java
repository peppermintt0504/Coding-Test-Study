class Solution {
    public int[] solution(int start, int end) {
        int[] answer = new int[start-end+1];
        for(int i = start; i >= end; i--){
            answer[start - i] = i;
        }
        return answer;
    }
}