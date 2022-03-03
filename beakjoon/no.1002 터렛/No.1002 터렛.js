const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`7
0 0 10 0 0 10
0 0 4 0 0 3
0 0 6 0 1 4
0 0 4 0 2 2
0 4 1 0 6 1
0 0 5 0 6 3
0 0 10 0 20 5`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let testCase = input();
while(testCase){
    let [x1,y1,r1, x2,y2,r2] = input().split(' ').map(v=>+v);
    
    const R = Math.sqrt(Math.pow(x1-x2,2) + Math.pow(y1-y2,2));

    
    //동일
    if(r1===r2 && R===0){
        console.log(-1);
        testCase -= 1;
        continue;
    }

    //동심원
    if(R === 0 && r1 !== r2){
        console.log(0);
        testCase -= 1;
        continue;
    }

    //내부
    if(R < Math.abs(r1-r2)){
        console.log(0);
        testCase -= 1;
        continue;
    }

    //내접
    if(Math.abs(r1-r2) === R){
        console.log(1);
        testCase -= 1;
        continue;
    }
    //외접
    if(r1 + r2 === R){
        console.log(1);
        testCase -= 1;
        continue;
    }

    //두 점
    if(r1 + r2 > R){
        console.log(2);
        testCase -= 1;
        continue;
    }
    //먼 거리
    if(r1 + r2 < R){
        console.log(0);
        testCase -= 1;        
        continue;
    }
}
