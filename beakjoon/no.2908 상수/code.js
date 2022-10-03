const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`810 230`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let [A, B] = input().split(" ").map(Number);
    
    A = Number(A.toString().split('').reverse().join(""));
    B = Number(B.toString().split('').reverse().join(""));

    console.log(Math.max(A,B))
}

solution();