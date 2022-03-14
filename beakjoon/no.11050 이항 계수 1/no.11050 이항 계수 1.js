const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5 4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    const [A, B] = input().split(' ').map(v=>+v);
    let answer = 1;
    if(B===0){
        console.log(1);
        return;
    }

    for(let i = B+1; i <= A; i++){
        answer *= i;
    }

    for(let i = 1; i <= A-B; i++){

        answer /= i;
    }
    console.log(answer);
}

solution();