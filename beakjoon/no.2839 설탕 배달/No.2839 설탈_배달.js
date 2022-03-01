const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : `11
`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let total = input();
let count = 0;

for(let i = 0; i <= parseInt(total/5); i++){
    let temp = total - (parseInt(total/5) - i) * 5;
    if(temp%3===0){
        console.log(parseInt(total/5) - i + temp/3);
        return;
    }
}
console.log(-1)
return;