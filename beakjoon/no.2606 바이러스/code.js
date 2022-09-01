const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`7
6
1 2
2 3
1 5
5 2
5 6
4 7`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = 1;
    const N = Number(input())
    const C = Number(input())
    let checkArr = Array(N).fill(0);
    let connetion = Array.from({length : N},()=>Array(N).fill(0));
    let queue = [0];
    for(let i = 0; i < C; i++){
        const [a,b] = input().split(" ").map((v)=>+v);
        connetion[a-1][b-1] = 1;
        connetion[b-1][a-1] = 1;
    }
    while(queue.length){
        const virus = queue.shift();
        checkArr[virus] = 1;
        connetion[virus].map((v,i)=>{
            if(v === 1 && checkArr[i]===0){
                checkArr[i]=1;
                queue.push(i);
            }
        })
    }
    console.log(checkArr.reduce((answer,v)=>v?answer+1:answer)-1);
    // console.table(connetion);
}

solution();