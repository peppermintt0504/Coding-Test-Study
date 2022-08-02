const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
``).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

function solution(){
    const date = new Date().toISOString().
    replace(/T/, ' ').      
    replace(/\..+/, '')    

    const answer = date.split(' ')[0];
    console.log(answer);
}

solution();