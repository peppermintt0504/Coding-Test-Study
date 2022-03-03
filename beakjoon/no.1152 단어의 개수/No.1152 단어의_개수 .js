const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`The last character is a blank `
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let answer = input().split(' ');

if(answer[0]===''){
    answer.shift();
}
if(answer[answer.length-1]===''){
    answer.shift();
}

console.log(answer.length);