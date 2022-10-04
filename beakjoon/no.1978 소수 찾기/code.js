const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4
1 3 5 7`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

const isPrime = ((n)=>{
    if(n === 1) return false;
    if(n === 2) return true;

    for (let i = 2; i * i <= n; i += 1) {
        // console.log(n,i,!(n%i));
        if(!(n%i))  return false;
    }
    return true;
})
    
function solution(n) {
    const N = Number(input());
    const arr = input().split(" ").map(Number);
    let answer = 0;
    
    for(a of arr){
        if(isPrime(a))  answer += 1;
    }
    console.log(answer)
}

solution();
