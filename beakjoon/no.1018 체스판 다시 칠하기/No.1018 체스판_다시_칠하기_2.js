const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10 13
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

function solution(){
    let data = [];
    let [C, R] = input().split(' ');
    let answer = 99;
    const WBoard = 'WBWBWBWB';
    const BBoard = 'BWBWBWBW';
    C = Number(C);
    R = Number(R);
    while(1){
        const inputData = input();
        if(!inputData)  break;
        data.push(inputData);
    }
    for(let i = 0; i < C-7; i++){
        for(let j = 0; j < R-7 ; j++){
            let toWhiteBoard = 0;
            let toBlackBoard = 0;
            for(let e = 0; e < 8; e++){
                let boardLine = data[i+e].slice(j,j+8);
                // console.log(boardLine);
                for(let c = 0; c < boardLine.length; c++){
                    if(boardLine[c] !== WBoard[c]){
                        e % 2 ? toBlackBoard += 1 : toWhiteBoard += 1;
                    }
                    if(boardLine[c] !== BBoard[c]){
                        e % 2 ? toWhiteBoard += 1 : toBlackBoard += 1;
                    }
                }
            }
            answer = Math.min(answer,toBlackBoard,toWhiteBoard)
            // if(answer === toBlackBoard || answer === toWhiteBoard){
            //     console.log(toBlackBoard,toWhiteBoard)
            //     for(let e = 0; e < 8; e++){
            //         let boardLine = data[i+e].slice(j,j+8);
            //         console.log(boardLine);
            //     }
            // }
        }
    }
    console.log(answer);
}

solution();