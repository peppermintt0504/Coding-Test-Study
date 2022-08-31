const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 6
110110
110110
111111
111101`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    let data = [];
    let [N,M] = input().split(' ').map((v)=>+v);
    let pos = [0,0];
    const check = Array.from({ length: N }, () => Array(M).fill(0)); // 방문 여부를 위한 체크 행렬
    for(let i = 0; i < N; i++){
        data.push(input().split('').map((v)=>+v));
    }
    
    const BFS = (pos) =>{
        const [row,col] = pos;
        const dx = [-1, 0, 1, 0];
        const dy = [0, 1, 0, -1]; // 현재 위치로부터 동서남북 조회를 위한 dx, dy 배열
        const queue = [];

        queue.push([row, col]);
        check[row][col] = 1;

        while (queue.length) {
            const [x, y] = queue.shift(); // 큐는 FIFO이므로, 맨 앞부터 꺼낸다.
            // console.log(x,y,check);
            for (let i = 0; i < 4; i++) {
                const [nx, ny] = [x + dx[i], y + dy[i]]; // (nx, ny)는 이동 가능성이 있는 좌표.
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue; // 미로를 벗어나는 좌표는 제외
                if (data[nx][ny] && !check[nx][ny]) { // 길이 있고, 방문하지 않았다면 방문
                check[nx][ny] = check[x][y] + 1; // (x,y)의 값이 (x,y)까지 최단경로에 해당한다.
                queue.push([nx, ny]); // BFS(너비 우선)로 현재 위치에서 갈 수 있는 좌표를 모두 큐에 넣어준다.
                }
            }
        }
    }

    BFS(pos);
    console.log(check[N-1][M-1])
}

solution();

