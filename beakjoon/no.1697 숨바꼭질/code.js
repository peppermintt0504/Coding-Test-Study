const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5 17`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


function solution(){
    const [N, K] = input().split(" ").map(Number);
    const visit = Array.from({ length: 100100 }, () => 0);

    function bfs(N) {
        const queue = [];
        queue.push([N, 0]);
        visit[N] = 1;
        while (queue.length) {
        const [cur, time] = queue.shift();
        if (cur === K) return time;
        for (next of [cur - 1, cur + 1, cur * 2]) {
            if (!visit[next] && next >= 0 && next <= 100000) {
            visit[next] = 1;
            queue.push([next, time + 1]);
            }
        }
        }
    }
    console.log(bfs(N));

}

solution(); 