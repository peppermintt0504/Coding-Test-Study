const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`1900`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    const N = Number(input());
    if((!(N % 4) && (N % 100 !== 0))|| !(N % 400)){
        console.log(1);
    }else console.log(0);
}

solution();