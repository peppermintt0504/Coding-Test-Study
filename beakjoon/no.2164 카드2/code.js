const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`6`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    if(N === 1){
        console.log(1);
        return;
    }
    let a = 0;

    while(Math.pow(2,a)<N){
        a++;
    }
    console.log((N-Math.pow(2,a-1))*2);
}

solution();
