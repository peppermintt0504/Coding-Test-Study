class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for(String s : my_string.split("")){
            if(s.equals(alp))   answer+= s.toUpperCase();
            else                answer += s;
        }
        return answer;
    }
}