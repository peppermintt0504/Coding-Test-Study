const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10 5
1 10 4 9 2 3 8 5 7 6`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let answer = '';
    
    let [N , X] = input().split(" ").map(Number);
    const arr = input().split(" ").map(Number).filter((v,i)=> X > v);

    console.log(arr.join(" "));

}

solution();
