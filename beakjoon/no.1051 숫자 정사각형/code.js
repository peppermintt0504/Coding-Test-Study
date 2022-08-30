const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`11 10
9785409507
2055103694
0861396761
3073207669
1233049493
2300248968
9769239548
7984130001
1670020095
8894239889
4053971072`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = Number.MIN_VALUE;
    let data = [];
    let [N,M] = input().split(' ').map((v)=>+v);
    for(let i = 0; i < N; i++){
        data.push(input().split('').map((v)=>+v));
    }
    // console.table(data);

    const search = (size) =>{
        if(size === 0){
            return
        }
        for(let i = 0; i <= N - size; i++){
            // console.log('i = ', i ,data[i]);
            for(let j = 0; j <= M - size; j++){
                const tempData = data[i][j];
                // console.log(tempData,'->',data[i][j] , data[i+size-1][j] , data[i][j + size-1] , data[i + size-1][j + size-1]);
                if(tempData === data[i+size-1][j] && tempData === data[i][j + size-1] && tempData === data[i + size-1][j + size-1])  answer = answer < size ? size : answer;
            }
        }
        search(size-1);
    }

    search(N);
    console.log(answer * answer);
}

solution();

