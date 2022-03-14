const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3
1 45000
6 10
13 17`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let line = input();
    while(line){
        line-=1;

        let GCD = 1;
        let LCM = 1;

        const [A, B] = input().split(' ').map(v=>+v).sort((a,b)=>a-b);

        for(let i=2; i<=A; i++){
            if(A % i === 0 && B % i === 0){
                GCD = i;
            }
        }
        LCM = A * B / GCD
        console.log(LCM);
    }
}

solution();