const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`8
71 39 44
32 83 55
51 37 63
89 29 100
83 58 11
65 13 15
47 25 29
60 66 19`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    const N = Number(input());
    const cost = [];
    let build = Array.from({ length: N-1 }, () => Array(3).fill(0));
    for(let i = 0; i < N; i++){
        cost.push(input().split(" ").map((v)=>+v));
    }

    build.unshift(cost[0]);

    for(let i = 1; i < N; i++){
        build[i][0] = cost[i][0] + Math.min(build[i-1][1],build[i-1][2])
        build[i][1] = cost[i][1] + Math.min(build[i-1][0],build[i-1][2])
        build[i][2] = cost[i][2] + Math.min(build[i-1][1],build[i-1][0])
    }
    
    console.log(Math.min(...build[build.length-1]));
}

solution();