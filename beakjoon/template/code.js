const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
1
3
8
-2
2`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let arr = [];
    for(let i = 0; i < N; i++){
        const [n,t] = input().split(" ").map(Number);
        const docs = input().split(' ').map((v,i)=>[+v,+i]);
        const arr = [];
        while(docs.length){
            if(docs[0][0] === Math.max(...docs.map((v)=>v[0]))){
                arr.push(docs[0]);
                docs.shift();
            }else{
                const temp = docs.shift();
                docs.push(temp);
            }
        }
        arr.map((v,i)=>{
            if(v[1] === t){
                answer += i+1 + '\n';
            }
        })
    }
    console.log(answer.trim());
}


solution();
