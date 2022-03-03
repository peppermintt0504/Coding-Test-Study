const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`baaa`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


const sentance = input()
let dic = {};

let maxValue = null;
let maxNum = 0;

for(let c of sentance){
    let temp;
    if(c.charCodeAt() > 'Z'.charCodeAt()){
        temp = c.charCodeAt()-32;
    }else{
        temp = c.charCodeAt();
    }
    if(dic[String.fromCharCode(temp)] === undefined){
        dic[String.fromCharCode(temp)] = 1;
    }else{
        dic[String.fromCharCode(temp)] += 1;
    }
}

for(const [key, value] of Object.entries(dic)){
    
    if(maxNum === value){
        maxValue = '?';
    }
    if(maxNum < value){
        maxNum = value;
        maxValue = key;
    }
}
console.log(maxValue);
