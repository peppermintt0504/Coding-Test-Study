import java.util.*;
class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> tempList = new ArrayList<>();        
        for(int i = 0; i < names.length; i +=5){
            tempList.add(names[i]);
        }
        // String[] answer = new String[];
        String[] answer = tempList.toArray(new String[0]);
        return answer;
    }
}