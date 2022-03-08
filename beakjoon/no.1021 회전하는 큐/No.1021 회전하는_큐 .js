const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10 10
1 6 3 2 7 9 8 4 10 5`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution(){
    const [N,M] = input().split(' ').map(v=>+v);
    let target = input().split(' ').map(v=>+v);
    let arr = [];
    for(let i = 0; i < N; i++)  arr.push(i+1);
    let count = 0;

    
    for(let i = 0; i < M; i++){
        let index = arr.indexOf(target[i]);
        if(index < arr.length-index){
            for(let j = 0; j < index ; j++){
                count += 1;
                let temp = arr.shift();
                arr.push(temp);
            }
        }
        else{
            for(let j = 0; j < arr.length-index ; j++){
                count += 1;
                let temp = arr.pop();
                arr.unshift(temp);
            }
        }
        arr.shift();
    }   
    console.log(count);
}

solution();