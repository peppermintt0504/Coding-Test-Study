const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`6 8 10
25 52 60
5 12 13
0 0 0`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    let answer = '';
    while(1){
        const [a,b,c] = input().split(' ').map(Number).sort((a,b)=>a-b);
        if(a + b + c === 0) break;
        if(Math.pow(c,2) === Math.pow(a,2) + Math.pow(b,2)){
            answer += 'right\n'
        }else{
            answer += 'wrong\n'
        }
    }
    console.log(answer.trim());
}

solution();
