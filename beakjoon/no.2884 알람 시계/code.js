const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`23 40`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let [H, M] = input().split(" ").map(Number);
    if(M < 45){
        if(H === 0) H = 23;
        else H -= 1;
        M = M + 15;
    }else{
        M -= 45;
    }
    console.log(H,M);
}

solution();