const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`6
1 2 3 4 5 6
2 1 1 1`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let max = Number.MIN_VALUE;
    let min = Number.MAX_VALUE;
    const results = [];
    let N = Number(input());
    let numbers = input().split(' ').map((v)=>+v);
    let operatorData = input().split(' ').map((v)=>+v);


    

    const DFS = (value,count) => {
        if(count === N) {
            results.push(value);
            return
        }
        for(let i = 0; i < 4; i++){
            if(operatorData[i] === 0) continue;

            operatorData[i] -= 1;
            switch(i){
                case(0):
                    DFS(value + numbers[count],count+1);
                    break;
                case(1):
                    DFS(value - numbers[count],count+1);
                    break;
                case(2):
                    DFS(value * numbers[count],count+1);
                    break;
                case(3):
                    DFS(parseInt(value / numbers[count]),count+1);
                    break;
            }   
            operatorData[i] += 1;
        }
    }
    DFS(numbers[0],1);
    console.log(Math.max(...results)===-0?0:Math.max(...results));
    console.log(Math.min(...results)===-0?0:Math.min(...results));

}

solution();

