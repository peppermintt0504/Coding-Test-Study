function solution(places) {
    var answer = [];
    
    const dx = [0,1,0,-1];
    const dy = [-1,0,1,0];
    
    const crossX = [-1 ,1,1,-1];
    const crossY = [-1 ,-1,1,1];
    
    const crossTempX = [[-1,0],[0,1],[1,0],[0,-1]];
    const crossTempY = [[0,-1],[-1,0],[0,1],[1,0]];
    
    places.forEach((place)=>{
        let isRight = 1;
        for(let i = 0; i < 5; i++){
            if(!isRight)break;
            
            for(let j = 0; j <5; j++){
                if(!isRight)break;
                if(place[i][j] !== "P") continue;
                
                for(let v = 0; v < 4; v++){
                    if(j+dx[v] <0 || j+dx[v] > 4 || i+dy[v] <0 || i+dy[v] >4)continue;
                    if(place[i+dy[v]][j+dx[v]] === "P"){
                        isRight = 0;
                        break;
                    }
                }
                
                for(let v = 0; v < 4; v++){
                    if(j+dx[v]*2 <0 || j+dx[v]*2 > 4 || i+dy[v]*2 <0 || i+dy[v]*2 >4)continue;
                    if(place[i+dy[v]*2][j+dx[v]*2] === "P"){
                        if(place[i+dy[v]][j+dx[v]] !== "X"){
                            isRight = 0;
                            break;
                        }
                    }
                }
                for(let v = 0; v < 4; v++){
                    if(j+crossX[v] <0 || j+crossX[v] > 4 || i+crossY[v] <0 || i+crossY[v] >4)continue;
                    if(place[i+crossY[v]][j+crossX[v]] === "P"){
                        if(place[i+crossTempY[v][0]][j+crossTempX[v][0]] === "X" && place[i+crossTempY[v][1]][j+crossTempX[v][1]] === "X"){}
                        else{
                            isRight = 0;
                            break;
                        }
                    }
                }
                
                
                
            }
        }
        answer.push(isRight);
    })
    
    return answer;
}