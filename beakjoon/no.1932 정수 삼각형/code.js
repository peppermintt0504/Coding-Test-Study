const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    let answer = 0;
    let N = Number(input());
    let dp = [];
    for(let i = 0; i < N; i++){
        dp.push(input().split(' ').map((v)=>+v));
    }

    for (let i = 1; i < N; i++) {
        for (let j = 0; j < dp[i].length; j++) {
            if (j == 0) dp[i][j] += dp[i - 1][j]
            else if (j == dp[i].length - 1) dp[i][j] += dp[i - 1][j - 1];
            else dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j])
        }
    }

    console.log(Math.max(...dp[N-1]));

}

solution(); 