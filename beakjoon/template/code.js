const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
0 4
1 2
1 -1
2 2
3 3`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


const n = Number(input());
let point = [];
let answer = '';
for(let i = 0; i < n; i++)  point.push(input().split(' ').map(Number));

point.sort((a,b)=>{
    if(a[1] === b[1])   return a[0]-b[0]
    else                return a[1]-b[1]
})

point.map((v)=>{
    answer += v.join(' ') + '\n';
})
console.log(answer.trim());