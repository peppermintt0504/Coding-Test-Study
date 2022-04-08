const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3
26 40 83
49 60 57
13 89 99`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

function solution(){
    let line = input();
    let house = [];
    while(line){
        line -= 1;
        const temp = input().split(' ').map(v=>+v);
        house.push(temp);
    }
    console.log(house);
}

solution();