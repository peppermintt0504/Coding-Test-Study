const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`2
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    const T = Number(input());
    
    for(let i = 0; i < T;i++){
        const N = Number(input());
        const DP = Array.from({length:N-1}, ()=>Array(3).fill(0))
        const data = [];

        data.push(input().split(" ").map((v)=>+v));
        data.push(input().split(" ").map((v)=>+v));

        DP.unshift([0,data[0][0],data[1][0]])
        
        for(let j = 1; j < N; j++){
            DP[j][0] = Math.max(DP[j-1][1],DP[j-1][2])
            DP[j][1] = Math.max(DP[j-1][0],DP[j-1][2]) + data[0][j]
            DP[j][2] = Math.max(DP[j-1][0],DP[j-1][1]) + data[1][j]
        }
        
        console.log(Math.max(...DP[N-1]));
    }
    
}

solution();