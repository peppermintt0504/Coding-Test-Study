import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] temp = num_list;
        Arrays.sort(temp);
        
        int[] answer = new int[5];
        
        for(int i = 0 ; i < 5; i++){
            answer[i] = temp[i];
        }
        
        return answer;
    }
}