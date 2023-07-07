class Solution {
    public int solution(String myString, String pat) {
        if(myString.toLowerCase().contains(pat.toLowerCase()))  return 1;
        else                                                    return 0;
    }
}