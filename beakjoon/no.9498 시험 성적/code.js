const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`8`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    const score = Number(input());

    if(score >= 90){
        console.log('A');
        return;
    }
    if(score >= 80){
        console.log('B');
        return;
    }
    if(score >= 70){
        console.log('C');
        return;
    }
    if(score >= 60){
        console.log('D');
        return;
    }
    console.log("F")
}

solution();