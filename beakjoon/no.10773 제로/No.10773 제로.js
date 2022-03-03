const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4
3
0
4
0`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


let line = input();
let stack = [];

while(line){
    const num = parseInt(input());

    if(num === 0){
        stack.pop();
    }else{
        stack.push(num);
    }
    line -= 1;
}

console.log(stack.reduce((x,v)=> x+v,0));