const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`25
7000000000000000000000000`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    input();
    const numbers = input().split('').map(Number);
    let answer = 0;
    for( n of numbers){
        answer += n;
    }
    console.log(answer)
}

solution();