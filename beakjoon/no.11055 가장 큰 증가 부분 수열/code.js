const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10
1 100 2 50 60 3 5 6 7 8`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    let answer = 0;
    let N = Number(input());
    const data = input().split(' ').map((v)=>+v);
    let dp = [];
    
    for(let i = 0; i < N;i++){
        dp[i] = data[i]
        for(let j = 0; j < i;j++){
            if(data[j] < data[i] && dp[i] < dp[j] + data[i]){
                dp[i] = dp[j] + data[i];
            }
        }
    }
    console.log(Math.max(...dp));

}

solution(); 