const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4
2 1 2 7`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

