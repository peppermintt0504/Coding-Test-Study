const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10
6 3 2 10 10 10 -10 -10 7 3
8
10 9 -5 2 3 4 5 -10`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let cardData = {};
    let deck = input().split(' ');
    const M = Number(input());
    let cards = input().split(' ');

    let answer = '';
    
    for(card of deck){
        if(cardData[card]){
            cardData[card] = cardData[card] + 1;
        }else{
            cardData[card] = 1;
        }
    }
    for(card of cards){
        if(cardData[card]){
            answer += cardData[card] + " ";
        }else{
            answer +=  "0 ";
        }
    }
    console.log(answer.trim());
}


solution();
