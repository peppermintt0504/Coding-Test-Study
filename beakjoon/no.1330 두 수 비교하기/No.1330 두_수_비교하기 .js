const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`1 2`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [A,B] = input().split(' ').map(v=>+v);


if(A>B)
    console.log('>');
if(A<B)
    console.log('<');
if(A===B)
    console.log('==');