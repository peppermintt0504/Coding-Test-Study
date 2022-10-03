const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`baekjoon`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let word = input().toLowerCase().split("");
    let answer = Array(26).fill(-1);
    let pos = 0;

    for(a of word){
        if(answer[a.codePointAt()-'a'.codePointAt()] === -1)    answer[a.codePointAt()-'a'.codePointAt()] = pos;
        pos += 1;
    }

    console.log(answer.join(" "));
}

solution();
