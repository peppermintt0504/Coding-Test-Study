class Solution {
    public int solution(String myString, String pat) {
        String str = "";
        
        for(String s : myString.split("")){
            if(s.equals("B")) str += "A";
            else              str += "B";
        }
        if(str.contains(pat))return 1;
        else return 0;
    }
}