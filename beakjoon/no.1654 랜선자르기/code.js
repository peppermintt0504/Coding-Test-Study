const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 11
802
743
457
539`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

function solution(){
    let data = [];
    let [N, K] = input().split(' ');
    N = Number(N);
    K = Number(K);
    while(1){
        const inputData = input();
        if(!inputData)  break;
        data.push(Number(inputData));
    }
    let [start,end] = [1,Math.max(...data)]
    let answer = 0;
    while(start <= end){
        let count = 0;
        const mid = Math.floor((start + end) / 2);
        for(let i = 0 ; i < N ; i++){
            const cutCount = Math.floor(data[i] / mid);
            count += cutCount;
        }
        if(count >= K){
            answer = mid;
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        
        // console.log('[',start,',',end,']')
    }
    console.log(answer);
}

solution();