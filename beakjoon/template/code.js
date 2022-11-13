const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    const target = Number(input());
    let visited = Array.from({length : 2000}, ()=>Array(1000).fill(0));
    let queue = [[1,0,0]];
    visited[1][0] = 1;

    const actionCase = {
        copy (count ,x){
            return [count ,count]
        },
        paste (count ,x){
            return [count + x, x]
        },
        deleteOne (count,x){
            return [count-1,x]
        }
    }

    while(queue.length){
        const [count,clip,time] = queue.shift();
        // console.log(count,':::');
        if(count === target){
            // console.log(count,clip,time);
            console.log(time);
            break;
        }
        for( action of ['copy','paste', 'deleteOne']){
            const NextPos = actionCase[action](count,clip);
            if( NextPos[0] > 0 && NextPos[0] < 2000 && !visited[NextPos[0]][NextPos[1]]){
                visited[NextPos[0]][NextPos[1]] = 1;
                queue.push([...NextPos,time+1])
                // console.log(action,[...NextPos,time+1]);
            }

        }
    }


}

solution(); 