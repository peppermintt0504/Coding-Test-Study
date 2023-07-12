import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> solution(String[] strlist) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(String str : strlist){
            answer.add(str.length());
        }
        return answer;
    }
}