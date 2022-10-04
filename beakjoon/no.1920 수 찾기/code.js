const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
4 1 5 2 3
5
1 3 7 9 5`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let data = {};
    let answer = '';
    const N = Number(input());
    const A = input().split(" ").map((v)=>{
        data[v] = 1;
    });
    const M = Number(input());
    const B = input().split(" ").map(Number);
    for(let i = 0; i < B.length; i++){
        if(i === B.length-1){
            if(data[B[i]] === 1)   answer += "1";
            else answer +="0";
            break;
        }
        if(data[B[i]] === 1)   answer += "1\n";
        else answer +="0\n"
    }
    console.log(answer);
}

solution();
