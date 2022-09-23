const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10
10 -4 3 1 5 6 -35 12 21 -1`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    let answer = 0;
    let N = Number(input());
    const data = input().split(' ').map((v)=>+v);
    let dp1 = [];
    let dp2 = [];
    
    for(let i = 0; i < N;i++){
        if(i === 0) {
            dp1[i] = data[i];
            continue;
        }
        dp1[i] = Math.max(dp1[i-1]+data[i],data[i]);
    }
    for(let i = 0; i < N;i++){
        if(i === 0) {
            dp2[i] = data[i];
            continue;
        }
        dp2[i] = Math.max(dp1[i-1],data[i]+dp2[i-1]);
    }
    console.log(Math.max(...dp1,...dp2));
}

solution(); 