const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`3 16`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [M,N] = input().split(' ');

const isPrimeNum = (num) => {
    if (num <= 1) return false;
    if (num === 2) return true;
    if (num % 2 === 0) return false;
    for (let i = 3; i <= Math.sqrt(num); i += 2) {
        if (num % i === 0) return false;
    }
    return true;
}

for(let i = parseInt(M); i <= parseInt(N); i++){
    isPrimeNum(i)?console.log(i):"";
}