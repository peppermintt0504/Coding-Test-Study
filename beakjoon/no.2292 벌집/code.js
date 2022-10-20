const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`13`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    const answer = 0;
    let deep = 1;
    let count = 1;
    if(N === 1) return console.log(1);

    while(1){
        count += 6*deep;
        if(N <= count){
            console.log(deep+1);
            break;
        }
        deep++;
    }
}


solution();
