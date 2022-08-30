const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`7 7
1011111
1110001
1000001
1000001
1000001
1000001
1111111`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let answer = Number.MAX_VALUE;
    let data = [];
    let [N,M] = input().split(' ').map((v)=>+v);
    let pos = [0,0];
    let count = 0;
    for(let i = 0; i < N; i++){
        data.push(input().split('').map((v)=>+v));
    }
    // console.table(data);

    const DFS = (pos,count) =>{
        if(pos[0]=== N - 1 && pos[1] === M -1){
            answer = answer > count + 1 ? count+1 : answer;
            return
        }
        const queue = [];
        // console.log(pos);
        // console.table(data);

        if(pos[0] < N - 1){
            if(data[pos[0]+1][pos[1]]===1){
                data[pos[0]][pos[1]] = 2;
                // DFS([pos[0]+1,pos[1]],count + 1);
                data[pos[0]][pos[1]] = 1;
                queue.push([pos[0]+1,pos[1]],0)
            }
        }
        if(pos[1] < M - 1){
            if(data[pos[0]][pos[1]+1]===1){
                data[pos[0]][pos[1]] = 2;
                // DFS([pos[0],pos[1]+1],count + 1);
                data[pos[0]][pos[1]] = 1;
                queue.push([pos[0],pos[1]+1],1)
            }
        }
        if(pos[0] > 0){
            if(data[pos[0]-1][pos[1]]===1){
                data[pos[0]][pos[1]] = 2;
                // DFS([pos[0]-1,pos[1]],count + 1);
                data[pos[0]][pos[1]] = 1;
                queue.push([pos[0]-1,pos[1]],2)
            }
        }
        if(pos[1] > 0){
            if(data[pos[0]][pos[1]-1]===1){
                data[pos[0]][pos[1]] = 2;
                // DFS([pos[0],pos[1]-1],count + 1);
                data[pos[0]][pos[1]] = 1;
                queue.push([pos[0],pos[1]-1],3)
            }
        }


    }

    DFS(pos,0);
    console.log(answer);
}

solution();

