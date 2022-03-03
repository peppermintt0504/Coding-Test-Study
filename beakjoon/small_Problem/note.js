const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`0`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

console.log(input().split('')[0].charCodeAt());