const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`1 1 5 5`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [x,y,w,h] = input().split(' ').map(v=>+v);

console.log(Math.min(x,y,w-x,h-y));