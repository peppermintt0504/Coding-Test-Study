const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3
21 Junkyu
21 Dohyun
20 Sunyoung`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let member = [];
    let answer = '';
    for(let n = 0; n < N; n++){
        const [age, name] = input().split(' ');
        member.push({age,name})
    }
    member.sort((a,b)=>a.age-b.age)
    member.map((v)=>{
        answer += v.age + ' ' + v.name+"\n";
    })
    console.log(answer.trim());
}


solution();
