const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
20 10 35 30 7`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    input();
    const numbers = input().split(" ").map(Number);
    console.log(Math.min(...numbers),Math.max(...numbers))
}

solution();