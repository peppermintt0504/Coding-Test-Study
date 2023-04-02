function solution(board) {
    const yLength = board.length;
    const xLength = board[0].length;
    let visited = Array.from({length : yLength},()=>Array(xLength).fill(0));
    let pos = [];
    let target = [];
    let answer = 0;
    
    board.forEach((y,i)=>{
        if(y.includes('R')){
            pos = [i,y.indexOf('R')]
        }
        if(y.includes('G')){
            target = [i,y.indexOf('G')]
        }
    })
    
    let queue = [[...pos,0]];
    visited[pos[0]][pos[1]] = 1;
    
    const moveX = [0,1,0,-1];
    const moveY = [-1,0,1,0];
    const direction = ['U','R','D','L'];
    
    while(queue.length){
        const cur = queue.shift();
        
        if(cur[0] === target[0] && cur[1] === target[1]){
            return cur[2];
        }
        for(let i = 0; i < 4; i++){
            const tempPos = [cur[0]+moveY[i],cur[1]+moveX[i]];
            let count = 0;
            if(tempPos[0] < 0 || tempPos[0] >= yLength || tempPos[1] < 0 || tempPos[1] >= xLength){
                continue;
            }
            if(board[tempPos[0]][tempPos[1]] === 'D'){
                continue;
            }
            switch(direction[i]) {
                case "U" :
                    count = 0;
                    while(tempPos[0]+count - 1 >= 0 && ['.','G','R'].includes(board[tempPos[0]+count - 1][tempPos[1]])   ){
                        count--;
                    }
                    if(visited[tempPos[0]+count][tempPos[1]] === 0){
                        queue.push([tempPos[0]+count,tempPos[1],cur[2]+1])
                        visited[tempPos[0]+count][tempPos[1]] = 1;
                    }
                    break;
                case "R" :
                    count = 0;
                    while(tempPos[1]+count + 1 < xLength && (['.','G','R'].includes(board[tempPos[0]][tempPos[1]+count + 1]))){
                        count++;
                    }
                    if(visited[tempPos[0]][tempPos[1]+count] === 0){
                        queue.push([tempPos[0],tempPos[1]+count,cur[2]+1])
                        visited[tempPos[0]][tempPos[1]+count] = 1;
                    }
                    break;
                case "D" :
                    count = 0;
                    while(tempPos[0]+count + 1 < yLength && ['.','G','R'].includes(board[tempPos[0]+count+1][tempPos[1]])){
                        count++;
                    }
                    if(visited[tempPos[0]+count][tempPos[1]] === 0){
                        queue.push([tempPos[0]+count,tempPos[1],cur[2]+1])
                        visited[tempPos[0]+count][tempPos[1]] = 1;
                    }
                    break;
                case "L" :
                    count = 0;
                    while(tempPos[1]+count - 1 >= 0 && (['.','G','R'].includes(board[tempPos[0]][tempPos[1]+count - 1]))){
                        count--;
                    }
                    if(visited[tempPos[0]][tempPos[1]+count] === 0){
                        queue.push([tempPos[0],tempPos[1]+count,cur[2]+1])
                        visited[tempPos[0]][tempPos[1]+count] = 1;
                    }
                    break;
            }
        }
        
    }
    
    return -1;
}