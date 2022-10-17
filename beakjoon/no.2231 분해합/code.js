const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`26`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    const answer = [];
    let num = 0+N;
    let rank = 0;
    while(Math.pow(10,rank) < num){
        rank++;
    }
    if(rank > 2){
        num -= 100;
        while(N !== num){
            const sum = num.toString().split('').reduce((x,v)=>{return Number(v)+x},num);
            if(sum === N){
                answer.push(num);
            }
            num++;
        }
    }else{
        num = 0;
        while(N !== num){
            const sum = num.toString().split('').reduce((x,v)=>{return Number(v)+x},num);
            if(sum === N){
                answer.push(num);
            }
            num++;
        }
    }
    console.log(answer.length === 0 ? 0 : Math.min(...answer));
}


solution();
