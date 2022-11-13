const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4
2 1 2 7`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const n = Number(input());
const numList = input().split(' ').map(Number);
let answer = Array(100010 * n).fill(0);
let search = 1;

for(let i = 1; i < Math.pow(2,n);i++){
    let binary = i.toString(2).split('').map(Number);
    if(binary.length !== n)   binary = Array(n - binary.length).fill(0).concat(binary)
    let sum = binary.reduce((x,v,j)=> (v * numList[n - 1 - j]) + x,0)
    answer[sum]= 1 ;
}

while(true){
    if(!answer[search]){
        console.log(search);
        break;
    }
    search++;
}
