const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = 0;
    let startTime = 0;
    let endTime = 0;
    let N = Number(input());
    let meeting = [];
    for(let i = 0; i < N;i++){
        meeting.push(input().split(' ').map((v)=>+v));
    }

    meeting = meeting.sort((a,b)=>{
        if(a[1] === b[1]){
            return a[0] - b[0]
        }
        else{
            return a[1] - b[1];
        }
    })
    for(let i = 0; i < N; i++){
        if(meeting[i][0] >= endTime){
            startTime = meeting[i][0];
            endTime = meeting[i][1];
            answer += 1;
        }
    }
    console.log(answer);
}

solution();