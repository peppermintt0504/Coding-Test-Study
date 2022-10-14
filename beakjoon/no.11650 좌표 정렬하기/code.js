const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
3 4
1 1
1 -1
2 2
3 3`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let answer ='';
    let store = [];
    for(let i = 0;  i < N; i++){
        store.push(input().split(" ").map(Number));
    }
    store.sort((a,b)=>{
        if(a[0] === b[0]){
            return a[1] - b[1];
        }else{
            return a[0] - b[0];
        }
    })
    store.map((v)=>{
        answer += v.join(' ') + '\n';
    })
    console.log(answer.trim());
}


solution();
