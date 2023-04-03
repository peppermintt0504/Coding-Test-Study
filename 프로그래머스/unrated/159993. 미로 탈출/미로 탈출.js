function solution(maps) {
    let start = [0,0];
    let end = [0,0];
    let lever = [0,0];
    let black = [];
    
    const h = maps.length
    const w = maps[0].length
    
    let visited = Array.from({length : h},()=>Array(w).fill(0));
    let afterVisited = Array.from({length : maps.length},()=>Array(maps[0].length).fill(0));
    maps.forEach((v,i)=>{
        for(j in v){
            if(v[j] === 'S')   start = [i,Number(j)];
            else if(v[j] === 'E')   end = [i,Number(j)];
            else if(v[j] === 'L')   lever = [i,Number(j)];
            else if(v[j] === 'X')   black.push([i,Number(j)]);
        }
    })
    
    let queue = [[...start,false,0]]
    visited[start[0]][start[1]] = 1;
    
    const NextX = [0,1,0,-1];
    const NextY = [-1,0,1,0];
    const direction = ['U','R','D','L'];
    while(queue.length){
        const [Y,X,leverOn,curCount] = queue.shift();
    
        if(end[0] === Y && end[1] ===X && leverOn) return curCount
        for(let i = 0; i < 4; i++){
            const tempX = Number(X) + Number(NextX[i]);
            const tempY = Number(Y) + Number(NextY[i]);
            const dir = direction[i]
            
            if(
                tempX < 0 ||
                tempY < 0 || 
                tempX >= w || 
                tempY >= h
            )  continue;
            
            if(maps[tempY][tempX] === 'X') continue;
            
            if(leverOn){
                if(afterVisited[tempY][tempX])   continue;
                
                queue.push([tempY,tempX,true,curCount+1]);
                afterVisited[tempY][tempX] = 1;
            }else{
                if(visited[tempY][tempX])   continue;
                else{
                    if(maps[tempY][tempX] === 'L'){
                        queue.push([tempY,tempX,true,curCount+1]);
                        afterVisited[tempY][tempX] = 1;
                    }else{
                        queue.push([tempY,tempX,false,curCount+1])
                        visited[tempY][tempX] = 1;
                    }
                }
            }
            
        }
    }
    return -1
}