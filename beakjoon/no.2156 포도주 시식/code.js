const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`6
6
10
13
9
8
1`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = [];
    let N = Number(input());
    let route = Array(N+1).fill(0)
    let wine = [];
    
    for(let i = 0; i < N;i++){
        wine.push(Number(input()));
    }
    route[1] = wine[0];
    route[2] = wine[0] + wine[1];

    //마마안 - 안마마
    for(let i = 3; i < N+1;i++){
        route[i] = Math.max(route[i-3]+wine[i-2]+wine[i-1],route[i-2]+wine[i-1],route[i-1]);
    }

    console.log(route[N]);

}

solution();