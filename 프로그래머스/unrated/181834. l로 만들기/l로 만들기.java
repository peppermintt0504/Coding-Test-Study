class Solution {
    public String solution(String myString) {
        int lAscii = (int) 'l';
        String answer = "";
        for(char c : myString.toCharArray()){
            if(lAscii > (int) c)    answer+="l";
            else                    answer+=c;
        }
        return answer;
    }
}