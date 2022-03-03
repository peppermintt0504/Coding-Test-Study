const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`4
1 100 100 100`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let count = input();
let arr = input().split(' ').map(v=>+v);

let max = arr.reduce((x,v)=> x<v?v:x,0);
let sum = arr.reduce((x,v)=> x+(v/max*100),0);

console.log(sum/count);