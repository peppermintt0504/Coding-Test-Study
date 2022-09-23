const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    const N = Number(input());
    const cost = [];
    let build = Array.from({ length: N-1 }, () => Array(10).fill(0));
    
    build.unshift([1,1,1,1,1,1,1,1,1,1]);


    for(let i = 1; i < N; i++){
        build[i][0] = (build[i-1][0]) % 10007
        build[i][1] = (build[i-1][0] + build[i-1][1]) % 10007
        build[i][2] = (build[i-1][0] + build[i-1][1] + build[i-1][2]) % 10007
        build[i][3] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3]) % 10007
        build[i][4] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3] + build[i-1][4]) % 10007
        build[i][5] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3] + build[i-1][4] + build[i-1][5]) % 10007
        build[i][6] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3] + build[i-1][4] + build[i-1][5] + build[i-1][6]) % 10007
        build[i][7] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3] + build[i-1][4] + build[i-1][5] + build[i-1][6] + build[i-1][7]) % 10007
        build[i][8] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3] + build[i-1][4] + build[i-1][5] + build[i-1][6] + build[i-1][7] + build[i-1][8]) % 10007
        build[i][9] = (build[i-1][0] + build[i-1][1] + build[i-1][2] + build[i-1][3] + build[i-1][4] + build[i-1][5] + build[i-1][6] + build[i-1][7] + build[i-1][8] + build[i-1][9]) % 10007
    }

    console.log(build[N-1].reduce((x,v)=> x += v,0)% 10007);
    
}

solution();