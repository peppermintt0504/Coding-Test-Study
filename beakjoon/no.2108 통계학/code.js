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
    let arr =[];
    let sum = 0;
    let number = {};
    let numMaxCount = [Number.MIN_SAFE_INTEGER,[0]];

    for(let i = 0; i < N; i++){
        const num = Number(input());
        sum += num;
        arr.push(num);
        if(number[num]){
            number[num] = number[num] + 1;
        }else{
            number[num] = 1;
        }
        if(number[num] > numMaxCount[0]){
            numMaxCount = [number[num],[num]];
        }else if(number[num] === numMaxCount[0]){
            numMaxCount[1] = [...numMaxCount[1],num].sort((a,b)=>a-b); 
        }
    }
    arr.sort((a,b)=>a-b);

    console.log(Math.round(sum / N) === -0 ? 0 : Math.round(sum / N));
    console.log(arr[parseInt(N/2)]);
    console.log(numMaxCount[1].length === 1 ? numMaxCount[1][0] : numMaxCount[1][1]);
    console.log((Math.max(...arr) - Math.min(...arr)) === -0 ? 0 : (Math.max(...arr) - Math.min(...arr)))
}


solution();
