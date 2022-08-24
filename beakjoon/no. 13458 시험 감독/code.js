const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
10 9 10 9 10
7 2`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution(){
    let data = [];
    let answer = 0;
    let N = input();
    const inputData = input().split(" ").map((a)=>+a);
    data.push(...inputData);
    let [M, S] = input().split(" ");

    for(let i = 0; i < N; i++){
        answer += 1 + (data[i]-M > 0 ?Math.ceil((data[i]-M) / S) : 0)
    }
    console.log(answer);
}

solution();
