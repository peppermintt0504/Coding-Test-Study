const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`1 1
1
0`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();



function solution(){
    let answer = 0;
    let [N , M] = (input().split(" ").map((v)=>+v));

    let A = [];
    let B = [];

    const reverseBoard = (a,b) =>{
        let tempBoard = [].concat(A);
        for(let i = 0; i < 3;i++){
            for(let j = 0; j < 3;j++){
                tempBoard[a+i][b+j] = tempBoard[a+i][b+j] === 1 ? 0 : 1; 
            }
        }
    }


    for(let i = 0; i < N; i++){
        A.push(input().split('').map((v)=>+v));
    }
    for(let i = 0; i < N; i++){
        B.push(input().split('').map((v)=>+v));
    }
    
    for(let i = 0; i < N - 2; i++){
        for(let j = 0; j < M - 2; j++){
            if(A[i][j] !== B[i][j]){
                reverseBoard(i,j);
                answer += 1;
            }
        }
    }
    console.log(JSON.stringify(A) === JSON.stringify(B) ? answer : -1);
    // console.table(A);
    // console.table(B);
}

solution(); 