const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10 4790
1
5
10
50
100
500
1000
5000
10000
50000`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = 0;
    let [N, K]=input().split(' ').map((v)=>+v);
    const coins = [];
    let current = 0;
    for(let i = 0; i < N;i++){
        coins.push(Number(input()));
    }

    for(let i = 0; i < N;i++){
        if(current + coins[N - 1 - i] > K)  continue;
        while(K-current >= coins[N-i-1]){
            current += coins[N-i-1];
            answer += 1;
        }
        if(current === K){
            console.log(answer);
            break;
        }
    }

}

solution();