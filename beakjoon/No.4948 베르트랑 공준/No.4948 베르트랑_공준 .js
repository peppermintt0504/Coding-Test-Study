const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : 
`1
10
13
100
1000
10000
100000
0
`
).split('\n');

const isPrimeNum = (num) => {
    if (num <= 1) return false;
    if (num === 2) return true;
    for (let i = 2; i <= Math.sqrt(num); i++) {
        if (num % i === 0) return false;
    }
    return true;
}

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let count = 0;

let t = input();
while (t!=='0') {
    count = 0;
    let num= parseInt(t) + 1;

    while(num <= (2 * t)){
        if(isPrimeNum(num))
            count += 1;
        num += 1;
    }
    console.log(count)
    t = input();
}