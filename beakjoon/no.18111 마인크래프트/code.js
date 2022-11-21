const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3 4 99
0 0 0 0
0 0 0 0
0 0 0 1`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


let [h,w,inven] = input().split(' ').map(Number);
let map = [];
let highist = 0;
let shortist = 256;
let overBlock = 0;
let shortBlack = 0;
let floor = 0;
let answer = [Number.MAX_VALUE,0];
for(let i = 0; i < h; i++) {
    const v = input().split(' ').map(Number)
    const max = Math.max(...v);
    const min = Math.min(...v);
    if(max>highist)  highist = max;
    if(min<shortist)  shortist = min;
    map.push(v);
}

// console.log(highist,shortist)

floor = highist;
while(floor >= shortist){
    // console.log('floor :',floor);
    overBlock = map.reduce((a,y)=>{
        const yValue = y.reduce((b,x)=>{
            if(x - floor > 0)
                return b + (x - floor);
            else
                return b
        },0)
        // console.log(yValue);
        return a + yValue;
    },0)

    shortBlack = map.reduce((a,y)=>{
        const yValue = y.reduce((b,x)=>{
            if(floor-x > 0)
                return b + (floor-x);
            else
                return b
        },0)
        // console.log(yValue);
        return a + yValue;
    },0)
    // console.log(overBlock);
    // console.log(shortBlack);
    if(inven + overBlock >=  shortBlack){
        const cost = overBlock*2 + shortBlack
        // console.log(cost);
        if(answer[0] > cost)   answer = [cost,floor];
    }
    floor--;
}

// console.table(map);
console.log(answer.join(' '));