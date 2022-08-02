const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`121
1231
12421
0`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

function solution(){
    let data = [];
    while(1){
        const inputData = input();
        if(!inputData)  break;
        data.push(inputData.split('').map((v)=>{return +v}));
    }
    data.pop();
    data.map((v,i)=>{
        let isPalindrom = true;
        for(let i = 0; i < Math.floor(v.length/2) ; i++){
            if(v[i] !== v[v.length-i-1]){
                isPalindrom = false;
            };
        }
        console.log(isPalindrom?'yes':'no');
    })
}

solution();