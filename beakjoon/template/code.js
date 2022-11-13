const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 2
0001
1000`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

const [tx,ty] = input().split(' ').map(Number);
let visited = Array.from({length : ty},()=>Array(tx).fill(0));
let maze = Array.from({length:ty},()=>input().split('').map(Number));

const queue = [[0,0,0]];
visited[0][0] = 1;

const move = {
    up(x,y){
        return [x,y-1];
    },
    down(x,y){
        return [x,y+1];
    },
    right(x,y){
        return [x+1,y];
    },
    left(x,y){
        return [x-1,y];
    }
}

while(queue.length){
    const [x,y,time] = queue.shift();
    // console.log(x,y,time);
    if(x === tx-1 && y === ty-1){
        // console.log('>>>',x,y,time);
        console.log(time);
        break;
    }

    for( action of ['up','down','right','left']){
        const [nx,ny] = move[action](x,y);
        if(ny < 0 || ny >= ty || nx < 0 || nx >= tx) continue;
        if(visited[ny][nx]) continue;
        if(maze[ny][nx]){
            queue.push([nx,ny,time+1]);
            visited[ny][nx] = 1;
        }else{
            queue.unshift([nx,ny,time]);
            visited[ny][nx] = 1;
        }
    }
}