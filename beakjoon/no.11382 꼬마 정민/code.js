const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`77 77 7777`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

function solution(){
    const data = input().split(' ');
    const answer = data.reduce((v,n,i)=>{
        return (v + Number(n))
    },0)
    console.log(answer);
}

solution();