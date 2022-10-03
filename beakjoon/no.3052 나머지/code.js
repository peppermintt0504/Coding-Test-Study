const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`1
2
3
4
5
6
7
8
9
10`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let answer =[];

    for(let i = 0; i < 10; i++){
        const number = input();
        if(!answer.includes(number%42)) answer.push(number%42)
    }
    console.log(answer.length);
}

solution();