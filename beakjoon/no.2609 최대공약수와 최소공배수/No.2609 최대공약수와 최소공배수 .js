const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`24 2`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let GCD = 1;
    let LCM = 1;
    const numbers = input().split(' ').map(v => +v).sort((a,b)=> a-b);

    for(let i=2; i<=numbers[0]; i++){
        if(numbers[0] % i === 0 && numbers[1] % i === 0){
            GCD = i;
        }
    }
    LCM = numbers[0] * numbers[1] / GCD
    console.log(GCD+'\n'+LCM);
}

solution();