const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`8
4 1 6 1 3 6 1 4`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let N = input();
let A = input().split(' ').map(v=> +v);
let answer = Array.from({ length: N });
let count = 0;

for(let i = 0; i < N ; i++){
    const minNum = Math.min(...A);
    const index = A.indexOf(minNum);
    answer[index] = count;
    count += 1;
    A[index] = 1001;
}


console.log(answer.join(" "));

