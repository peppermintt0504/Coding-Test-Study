import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        
        for(int num : arr){
            for(int i = 0; i < num; i++){
                tempList.add(num);
            }
        }
        
        int[] answer = new int[tempList.size()];
        for(int i = 0; i < tempList.size(); i++){
            answer[i] = tempList.get(i);
        }
        return answer;
    }
}