const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
3 1 4 3 2`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const QS = (arr) =>{
    if(arr.length <= 1)    return arr;

    const P = arr.shift();
    const left = [];
    const right = [];

    for(let i = 0; i < arr.length; i++){
        if(arr[i] <= P) left.push(arr[i]);
        else right.push(arr[i]);
    }

    return [...QS(left),P,...QS(right)]
}

function solution(){
    let answer = 0;
    let N = Number(input());
    const time = QS(input().split(" ").map((v)=>+v));
    time.map((v,i)=>{
        answer += v * (N - i);
    })
    console.log(answer);
}

solution();