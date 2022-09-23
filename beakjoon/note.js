const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`1 1
1
0`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    let answer = 0;
    let [N , M] = (input().split(" ").map((v)=>+v));

}

solution(); 