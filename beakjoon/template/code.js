const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5 20
4 42 40 26 46`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const [N,M] = input().split(' ').map(Number);
    const woods = input().split(' ').map(Number);
    let height = Math.max(...woods)-1;
    while(1){
        const cutedWoodHeight = woods.reduce((x,v)=>{
            return v-height > 0 ? x + v - height : x;
        },0)
        if(cutedWoodHeight >= M){
            break;
        }
        height--;
    }
    console.log(height);
}


solution();
