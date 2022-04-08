const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 5 1
1 2
1 3
1 4
2 4
3 4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


//DFS함수 
function DFS(v) { 
    //노드 방문처리 
    visited[v] = true; 
    //출력을 위해 리스트에 노드 삽입 
    DFS_graph.push(v); 
    for (let i = 1; i < graph.length; i++) {
        //graph에 1이 있고 방문하지 않았다면 재귀 호출 
        if (graph[v][i] === 1 && visited[i] === false) { 
            DFS(i);
        }
    }
}
//BFS함수 
function BFS(v) {
    let Queue = []; 
    //시작노드 큐에 삽입 
    Queue.push(v); 
    //시작 노드 방문처리 
    BFS_graph.push(v); 
    //큐에 값이 있을동안 계속 반복 
    while (Queue.length !== 0) { 
        //큐에서 하나를 빼서 그 노드 방문처리 
        let dequeue = Queue.shift(); 
        visited2[dequeue] = true; 
        for (let i = 1; i < graph.length; i++) { 
            //큐에서 뺀 노드를 반복하면서 노드와 연결된 
            //다른 노드들 중 1이 있고 방문하지 않았다면 
            if (graph[dequeue][i] === 1 && visited2[i] === false) { 
                //연결 노드 방문처리 후 큐와 출력을 위한 배열에 삽입 
                visited2[i] = true; Queue.push(i); BFS_graph.push(i);
            } 
        } 
    }

    return; 
}

//전역변수로 사용하는 것들 
let graph = []; 
let visited = []; 
let visited2 = []; 
let DFS_graph = []; 
let BFS_graph = [];


function solution(){
    let [n,m,v] = input().split(' ').map(v=>+v);
    graph = Array.from(Array(n + 1), () => Array(n + 1).fill(0));

    
    while(m){
        const [X,Y] = (input().split(' ').map(v=>+v));
        graph[X][Y]=1;
        graph[Y][X]=1;
        m -= 1;
    }

    //DFS, BFS 각각 방문 처리를 위해 두개 사용 
    visited = new Array(n + 1).fill(false); 
    visited2 = new Array(n + 1).fill(false); 
    DFS(v); 
    BFS(v); 
    //DFS, BFS처리 후 출력 
    console.log(DFS_graph.join(" ")); 
    console.log(BFS_graph.join(" "));

}

solution();