const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3
4
7
10`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    const answer = [];
    const data = [];
    let memo = [0,1,2,4];
    const N = Number(input())
    for(let i = 0; i < N; i++){
        const tempData = Number(input());
        data.push(tempData);
    }
    var num = Math.max(...data);
    for(let j=4; j<=num; j++){
        memo[j] = (memo[j-1] + memo[j-2] + memo[j-3]) % 1000000009;
    }

    for(let i=0; i<N; i++){
        console.log(memo[data[i]]);
    }



}

solution();