import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> strList = new ArrayList<>();
        
        for(String str : my_string.trim().split(" ")){
            if(str.equals(""))continue;
            strList.add(str);
        }
        String[] answer = new String[strList.size()];
        for(int i = 0; i < strList.size(); i++){
            answer[i] = strList.get(i);
        }
        return answer;
    }
}