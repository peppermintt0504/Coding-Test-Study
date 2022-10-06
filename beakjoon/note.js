const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
OOXXOXXOOO
OOXXOOXXOO
OXOXOXOXOXOXOX
OOOOOOOOOO
OOOOXOOOOXOOOOX`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    const N = Number(input());
    for(let i = 0; i < N;i++){
        let answer = 0;
        const score = input();
        let currect = 0;
        for(a of score){
            if(a === 'O'){
                answer += 1 + currect;
                currect += 1;
            }
            else{
                currect = 0;
            }
        }
        console.log(answer);
        console.log(answer);
    }
}

solution(); 