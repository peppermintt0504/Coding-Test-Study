const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

let line = parseInt(input());
let count = 1;
let arr = [];
while(line){
    let temp = '';
    for(let j = count; j < line + count; j++){
        temp += ' ';
    }

    for(let i = 0; i < count; i++){
        temp += '*';
    }
    arr.push(temp);
    count += 1;
    line -= 1;
}
console.log(arr.join("\n"));