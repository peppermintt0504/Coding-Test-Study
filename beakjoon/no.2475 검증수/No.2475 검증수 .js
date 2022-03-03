const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`0 4 2 5 6`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [n1,n2,n3,n4,n5] = input().split(' ').map(v=>+v);

console.log((Math.pow(n1,2)+Math.pow(n2,2)+Math.pow(n3,2)+Math.pow(n4,2)+Math.pow(n5,2))%10)