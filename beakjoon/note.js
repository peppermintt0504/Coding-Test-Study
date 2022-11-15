const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 7
20 15 10 17`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [tree, need] = input().split(' ').map(Number);
const trees = input().split(' ').map(Number);
let highist = Math.max(...trees);
let shortist = 0; 
let mid = 0;
let answer = 0;

while(shortist <= highist){
    let treelength = 0;
    mid = Math.floor((highist + shortist)/2);
    console.log(highist, shortist, mid);
    trees.forEach((v,i)=>{
        v - mid > 0 && (treelength += v - mid);

    })
    console.log(treelength)
    if(treelength >= need){
        mid > answer && (answer = mid);
        shortist = mid + 1;
    }else{
        highist = mid - 1;
    }
}
console.log(answer);