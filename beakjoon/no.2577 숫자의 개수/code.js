const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`150
266
427`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    const A = input();
    const B = input();
    const C = input();
    const answer = Array(10).fill(0);

    const multi = (A * B * C).toString().split("").map(Number);

    for( a of multi){
        answer[a] += 1;
    }

    for( a of answer){
        console.log(a);
    }
}

solution();