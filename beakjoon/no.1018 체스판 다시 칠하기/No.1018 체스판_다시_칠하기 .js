const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`9 23
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBB
BBBBBBBBBBBBBBBBBBBBBBW`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const board1 = ["BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB",
                "BWBWBWBW","WBWBWBWB","BWBWBWBW","WBWBWBWB"];
const board2 = ["WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW",
                "WBWBWBWB","BWBWBWBW","WBWBWBWB","BWBWBWBW"];

const [N,M] = input().split(' ').map(v=>+v);

const origin = [];
for(let i = 0; i < N ; i++){
    origin.push(input());
}

let min = 65;


for(let i = 0; i < M - 8 + 1; i++){
    for(let j = 0; j < N - 8 + 1; j++){
        let b1 = 0;
        let b2 = 0;

        for(let a = 0; a < 8; a++){
            for(let b = 0; b < 8; b++){
                origin[j+a].slice(i,i+8)[b] === board1[a][b]? '': b1 += 1;
            }
        }

        for(let a = 0; a < 8; a++){
            for(let b = 0; b < 8; b++){
                origin[j+a].slice(i,i+8)[b] === board2[a][b]? '': b2 += 1;
            }
        }
        min = Math.min(min,b1,b2);
    }
}

console.log(min);