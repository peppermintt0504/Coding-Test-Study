const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10 6 4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


let [N,y,x] = input().split(' ').map(Number);
let answer = 0;
const twoXtwoCase = {
    '00' : 0,
    '10' : 1,
    '01' : 2,
    '11' : 3
}

let xscale = 0;
let yscale = 0;

while(y >= 2 || x >= 2){
    xscale = 0;
    yscale = 0;
    while(Math.pow(2,xscale + 1) <= x)   xscale++;
    while(Math.pow(2,yscale + 1) <= y)   yscale++;
    
    if(yscale > 0){
        answer += Math.pow(2,1+(2*yscale));
        y -= Math.pow(2,yscale);
    }
    if(xscale > 0){
        answer += Math.pow(2,(2*xscale));

        x -= Math.pow(2,xscale);
    }
}
console.log(answer+ twoXtwoCase[[x,y].join('')]);