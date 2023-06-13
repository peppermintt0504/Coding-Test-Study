function solution(n, roads, sources, destination) {
    var answer = [];
    let road = Array.from({length : n + 1}, ()=>Array(0));
    const shortest = Array(n+1).fill(-1);
    roads.forEach((v)=>{
        const [a, b] = v;
        road[a].push(b);
        road[b].push(a);
    })
    
    const queue = [[destination,0]];
    const visited = Array(n+1).fill(false);
    visited[destination] = true;
    shortest[destination] = 0;
    
    while(queue.length){
        const [t , count] = queue.shift();
        road[t].forEach((v)=>{
            if(!visited[v]){
                queue.push([v,count+1]);
                visited[v] = true;
                shortest[v] = count+1;
            }
        })
    }
    
    return sources.map((v)=>{
        return shortest[v];
    });
}