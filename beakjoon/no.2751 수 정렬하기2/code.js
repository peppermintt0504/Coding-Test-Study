const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
5
4
3
2
1`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let arr = [];
    for(let i = 0; i < N;i++){
        arr.push(Number(input()));
    }
    arr = arr.sort((a,b)=>a-b)
    console.log(arr.join('\n'));
}

solution();
