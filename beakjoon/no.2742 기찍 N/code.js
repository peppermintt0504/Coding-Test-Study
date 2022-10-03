const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    const N = Number(input());
    let answer = ''
    for(let i = 0; i < N; i++){
        if(i === N-1){
            answer += (N-i);
            break;
        }
        answer += (N-i) + '\n'

    }
    console.log(answer)
}

solution();