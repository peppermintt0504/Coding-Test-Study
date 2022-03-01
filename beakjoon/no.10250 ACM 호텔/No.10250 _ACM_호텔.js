const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : 
`2
6 12 18
30 50 72`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let line = input();

while(line){
    let Ho = '0';
    let floow = '0';
    let temp = input().split(' ');

    let H = parseInt(temp[0]);
    let W = parseInt(temp[1]);
    let N = parseInt(temp[2]);

    if(Math.ceil(N / H) < 10){
        Ho = '0' + String(Math.ceil(N / H));
    }else{
        Ho = String(Math.ceil(N / H));
    }
    
    if(N % H === 0){
        floow= String(H);
    }
    else{
        floow = String(N % H);
    }
    console.log(floow+Ho);

    line -= 1;
}

