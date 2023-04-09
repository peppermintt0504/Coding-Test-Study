function solution(n, edge) {
    var answer = 0;
    const minRoute = Array(n).fill(200001);
    const edges = {};
    edge.forEach(([a,b])=>{
        if(edges[a]){
            edges[a] = [...edges[a],b];
        }else{
            edges[a] = [b];
        }
        
        if(edges[b]){
            edges[b] = [...edges[b],a];
        }else{
            edges[b] = [a];
        }
    })
    const visited = Array(n+1).fill(0);
    visited[1] = 1;
    minRoute[0] = 0;
    minRoute[1] = 0;
    
    const queue = [[1,0]];
    
    while(queue.length){
        const [target,count] = queue.shift();
        if(edges[target]){
            edges[target].forEach((v)=>{
                if(!visited[v]){
                    visited[v] = 1;
                    queue.push([v,count+1]);
                    minRoute[v] = count + 1;
                }
            })
        }
        
    }
    return (minRoute.filter((v)=>v===Math.max(...minRoute)).length)
}

