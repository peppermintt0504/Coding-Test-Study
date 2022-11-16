const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`8
99 193
46 155
46 155
46 155
46 155
46 155
46 155
46 155
46 155
46 155`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const n = Number(input());
let answer = Array(n).fill(0);
let people = [];

for(let i = 0; i < n; i++)  people.push(input().split(' ').map(Number).concat(i))

for(let i = 0; i < n; i++){
    let rank = 1;
    for(let j = 0; j < n; j++){
        if(i === j) continue;
        if(people[i][0] < people[j][0] && people[i][1] < people[j][1])  rank++;
    }
    answer[i] = rank
}
console.log(answer.join(' ').trim());