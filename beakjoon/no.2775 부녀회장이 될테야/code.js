const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`2
1
3
2
3`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    for(let i = 0; i < N;i++){
        const k = Number(input());
        const n = Number(input());
        let apart = Array.from({length:n},(v,i)=>i+1);

        for(let j = 0; j < k; j++){
            for(let x = 1; x < n; x++){
                apart[x] += apart[x-1];
            }
        }
        console.log(apart[n-1]);
    }
}


solution();
