const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`6`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());

    let cards = Array.from({length : N},(v,i)=>i+1);

    while(cards.length !== 1){
        cards.shift();
        if(cards.length === 1)  break;
        const temp = cards.shift();
        cards.push(temp)
    }
    console.log(cards[0]);
}

solution();
