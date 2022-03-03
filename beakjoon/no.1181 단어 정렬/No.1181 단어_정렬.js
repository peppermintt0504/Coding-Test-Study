const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString():
`13
but
i
wont
hesitate
no
more
no
more
it
cannot
wait
im
yours`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

let line = input();
let dic = [];
let temp = '';
while(line){
    const word = input();
    dic.includes(word)?'':dic.push(word);
    line -= 1;
}

dic.sort((a,b) => a.localeCompare(b))
dic.sort((a,b) => a.length - b.length)

for(let c of dic){
    console.log(c);
}