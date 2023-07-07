class Solution {
    public String solution(String rny_string) {
        String answer = "";
        for(String s : rny_string.split("")){
            if(s.equals("m"))answer += "rn";
            else                answer += s;
        }
        return answer;
    }
}