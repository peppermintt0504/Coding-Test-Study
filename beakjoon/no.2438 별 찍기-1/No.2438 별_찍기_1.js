const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

let line = input();
let count = 1;

while(line){
    let temp = '';
    for(let i = 0; i < count; i++){
        temp += '*';
    }
    console.log(temp);
    count += 1;
    line -= 1;
}