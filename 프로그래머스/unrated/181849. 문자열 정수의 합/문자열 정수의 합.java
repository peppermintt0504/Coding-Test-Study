class Solution {
    public int solution(String num_str) {
        int answer = 0;
        for(String n : num_str.split("")){
            answer+= Integer.parseInt(n);
        }
        return answer;
    }
}