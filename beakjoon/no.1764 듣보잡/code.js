const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3 4
ohhenrie
charlie
baesangwook
obama
baesangwook
ohhenrie
clinton`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = [];
    const [D,B] = input().split(' ').map((v)=>+v);
    let DList = {};
    let BList = [];
    for(let i = 0; i < D; i++){
        DList[input()] = 1;
    }
    for(let i = 0; i < B; i++){
        const BPerson = input();
        if(DList[BPerson]){
            answer.push(BPerson);
        }
    }
    console.log(answer.length)
    const sortedAnswer = answer.sort();
    for(let i = 0; i < answer.length; i++)  console.log(sortedAnswer[i])
}

solution();