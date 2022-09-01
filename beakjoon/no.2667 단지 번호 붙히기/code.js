const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`7
0110100
0110101
1110101
0000111
0100000
0111110
0111000`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = [];
    const N = Number(input())
    // let checkArr = Array(N).fill(0);
    let connetion = Array.from({length : N},()=>Array(N).fill(0));
    let data = [];
    let area = 1;
    let homeCount = 0;
    for(let i = 0; i < N; i++){
        const tempData = input().split("").map((v)=>+v);
        data.push(tempData);
    }

    const quickSort = (arr) =>{
        if(arr.length < 2)  return arr;
        
        const pivot = arr[0];
        const left = [];
        const right = [];

        for(let i = 1; i < arr.length; i++){
            if(arr[i] < pivot)  left.push(arr[i]);
            else    right.push(arr[i]);
        }

        return [...quickSort(left),pivot,...quickSort(right)]
    }

    const BFS = (row,col) =>{
        const nx = [1,0,0,-1];
        const ny = [0,1,-1,0];
        let queue = [];
        queue.push([row,col])
        connetion[row][col] = area;
        homeCount += 1;
        while(queue.length){
            const [x,y] = queue.shift();
            for(let i = 0; i < 4; i++){
                if(x+nx[i] < 0 || x+nx[i] >N-1 || y+ny[i] < 0 || y+ny[i] >N-1)  continue;
                if(data[x+nx[i]][y+ny[i]] && connetion[x+nx[i]][y+ny[i]] === 0){
                    queue.push([x+nx[i],y+ny[i]]);
                    connetion[x+nx[i]][y+ny[i]] = area;
                    homeCount += 1;
                }
            }
        }
        answer.push(homeCount);
    }
    
    
    for(let i = 0; i < N; i++){
        for(let j = 0; j < N; j++){
            if(data[i][j] === 1 && connetion[i][j] === 0){
                homeCount = 0;
                BFS(i,j);
                area += 1;
            }
        }
    }
    
    
    // console.table(connetion);
    const sortedAnswer = quickSort(answer);
    console.log(area-1);
    for(let i = 0; i < sortedAnswer.length; i++){
        console.log(sortedAnswer[i]);
    }
}

solution();