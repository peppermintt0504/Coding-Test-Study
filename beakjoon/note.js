const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 3
0
2 1 2
1 3
3 2 3 4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

    function combination(arr, selectNum) {
        const result = [];
        if (selectNum === 1) return arr.map((v) => [v]);

        arr.forEach((v, idx, arr) => {
        const fixed = v;
        const restArr = arr.slice(idx + 1);
        const combinationArr = combination(restArr, selectNum - 1);
        const combineFix = combinationArr.map((v) => [fixed, ...v]);
        console.log(fixed,restArr,combinationArr,combineFix);
        result.push(...combineFix);
        });

        return result;
    }
    
function solution(){
    combination([1,6,3,8,3,2],3)
}

solution();