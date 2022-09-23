const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`2`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    let N = Number(input());
    if(N%2) return console.log(0);
    let dp = Array(N+1).fill(0);
    dp[0] = 1;
    dp[2] = 3;

    for(let i = 4; i <= N; i+=2){
        dp[i]= dp[i-2]*3;
        for(let j = 4; j <= i; j+=2){
            dp[i] += dp[i-j] * 2;
        }
    }
    console.log(dp[N]);
}

solution(); 