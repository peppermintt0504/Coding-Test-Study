const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`7 3`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const [N, K] = input().split(" ").map(Number);
    let answer =[];
    let table = Array.from({length:N},(v,i)=>i+1);
    let count = 0;
    for(let i = 0; i < N; i++){
        count += K-1;
        while(count >= table.length){
            count -= table.length
        }
        answer.push(table[count]);
        table = [...table.slice(0,count) , ...table.slice(count+1,table.length)]
    }
    console.log('<'+answer.join(", ").trim()+">")
}


solution();
