function solution(n)
{
    let num = n;
    let answer = 0;
    while(num){
        if(num % 2){
            num--;
            answer++;
        }
        num /= 2;
    }
    return answer
//     const dp = Array(num+1).fill(0);
    
//     dp[1] = 1;
//     dp[2] = 1;
    
//     for(let i = 3; i <= num; i += 2){
//         if(i % 2){
//             dp[i] = Math.min(n,dp[i - 1] + 1);
//         }else{
//             dp[i] = Math.min(n,dp[i/2],dp[i - 1] + 1);
//         }
//     }
//     return dp[num];
}