const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `5 1 6`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const temp = input().split(' ');

const A = parseInt(temp[0]);
const B = parseInt(temp[1]);
const V = parseInt(temp[2]);

let distance = V-A;
let day = 1 + Math.ceil(distance / (A-B));

console.log(day);


