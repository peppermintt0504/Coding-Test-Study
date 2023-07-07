import java.util.*;
class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int i = k; i <= n; i+=k){
            numList.add(i);
        }
        int[] answer = new int[numList.size()];
        for(int i = 0; i < numList.size();i++){
            answer[i] = (numList.get(i));
        }
        return answer;
    }
}