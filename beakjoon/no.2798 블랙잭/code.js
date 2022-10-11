const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5 21
5 6 7 8 9`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

const getCombinations = (array, selectNumber) => {
    const results = [];
    if(selectNumber === 1){
        return array.map((element) => [element]);
    }
    array.forEach((fixed, index, origin) => {
        const rest = origin.slice(index+1);
        const combinations = getCombinations(rest, selectNumber - 1);
        const attached = combinations.map((combination) => [fixed, ...combination]);
        results.push(...attached);
    });
    return results;
}

function solution() {
    const [N,T] = input().split(' ').map(Number);
    const cards = input().split(' ').map(Number);
    let answer = 0;
    getCombinations(cards,3).map((v)=>{
        const sum = v[0] + v[1] + v[2];
        if(sum <= T){
            answer = Math.max(sum,answer);
        }
    });
    console.log(answer);
}

solution();
