const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`4
0 3
1 5
45 50
0 15`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let line = input();

while(line){
    let temp = input().split(' ');
    let distance = temp[1] - temp[0];
    if(distance <= 3){
        console.log(distance);
        line -= 1;
        continue;
    }

    let sqrt = Math.floor(Math.sqrt(distance));
    if(distance === Math.pow(sqrt,2)){
        console.log(2*sqrt - 1);
    }else if(distance <= Math.pow(sqrt,2) + sqrt){
        console.log(2*sqrt);
    }else{
        console.log(2*sqrt + 1);
    }


    line -= 1;
}
