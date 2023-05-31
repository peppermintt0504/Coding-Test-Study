function solution(maps) {
    const m = maps.length;
    const n = maps[0].length;
    
    const nx = [0,1,0,-1];
    const ny = [-1,0,1,0];
    
    const queue = [];
    const visited = Array.from({length : m}, ()=>Array(n).fill(0));
    
    queue.push([0,0,1]);
    visited[0][0] = 1;
    
    while(queue.length){
        const [x,y,count] = queue.shift();
        
        if(x === n - 1 && y === m - 1)  return count;
        
        for(let i = 0; i < 4; i++){
            if(x+nx[i] < 0 || x+nx[i] >= n || y+ny[i] < 0 || y+ny[i] >= m) continue;
            if(visited[y+ny[i]][x+nx[i]] === 0 && maps[y+ny[i]][x+nx[i]] === 1){
                queue.push([x+nx[i],y+ny[i],count+1]);
                visited[y+ny[i]][x+nx[i]] = 1;
            }
            
        }
        
    }

    return -1;
}