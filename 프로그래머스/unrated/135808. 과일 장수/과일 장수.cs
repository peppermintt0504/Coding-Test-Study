using System;

public class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Array.Sort(score);
        Array.Reverse(score);
        for(int i = 1; i <= score.Length / m; i++){
            int min = k;
            for(int j = m * (i - 1); j < m * i;j++){
                if(min > score[j]){
                    min = score[j];
                }
                
            }
            answer += min * m;
        }
        return answer;
    }
}