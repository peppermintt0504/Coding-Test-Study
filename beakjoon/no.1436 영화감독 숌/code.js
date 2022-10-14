const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`500`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let count = 0;
    let num = 666;
    while(1){
        if(num.toString().includes('666')){
            count++;
        }
        if(N === count){
            console.log(num);
            break;
        }
        num++;
    }
}


solution();
