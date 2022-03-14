const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`14
14 26456 2 28 13228 3307 7 23149 8 6614 46298 56 4 92596`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let line = input();
    const list = input().split(' ').map(v => +v);
    return Math.max(...list) * Math.min(...list);
}

console.log(solution());