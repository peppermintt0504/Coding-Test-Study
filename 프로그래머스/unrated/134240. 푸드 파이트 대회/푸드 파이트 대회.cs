using System;

public class Solution {
    public string solution(int[] food) {
        string answer = "";
        for(int i = 1; i < food.Length; i++){
            for(int j = 0; j < food[i] / 2;j++){
                answer += i.ToString();
            }
        }
        
        char[] chars = answer.ToCharArray();
        Array.Reverse(chars);
        
        return answer + '0' + new string(chars);
    }
}