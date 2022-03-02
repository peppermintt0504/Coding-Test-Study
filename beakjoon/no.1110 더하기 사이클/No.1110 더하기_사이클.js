const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`71`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let num = parseInt(input());
if( num < 10 ){
    num = num * 10;
}
let result = num%10*10 + ((parseInt(num/10) + num%10) %10);
let count = 1;

while( result !== num ){
    result = result%10*10 + ((parseInt(result/10) + result%10) %10);
    count += 1;
}

console.log(count);