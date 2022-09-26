function solution(wall) {
    let answer = Array.from({length : wall.length},()=>Array(wall[0].length).fill(0));
    let splitWall = [];
    let queue = [];
    let N = wall.length;
    let M = wall[0].length;

    wall.map((v)=>{
        splitWall.push(v.split(''));
    })

    queue.push([N-1,0])
    answer[N-1][0] = 1;
    // queue.push([N-1,M-1])
    // answer[N-1][M-1] = 1;
    const moveX = [0,0,-2,0,0,-1,-1,-1,1,0,0];
    const moveY = [-2,2,0,-3,3,-1,1,0,0,-1,1];

    while(queue.length){
        const [posX,posY] = queue.shift();
        count = answer[posX][posY] + 1;
        for(let i = 0; i < moveX.length;i++){
            if(posX+moveX[i] < 0 || posX+moveX[i] > N-1 || posY + moveY[i] < 0 || posY + moveY[i] > M-1)    continue;

            if(answer[posX+moveX[i]][posY + moveY[i]] === 0 && splitWall[posX+moveX[i]][posY + moveY[i]] === 'H'){

                if(i === 0){
                    if(posX === 0)  continue;
                    let enable = true;
                    for(let j = 0; j <3;j++){
                        if(splitWall[posX-1][posY-j] !== '.') enable = false;
                    }
                    if(splitWall[posX][posY-1] !== '.') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] =Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }

                if(i === 1){
                    if(posX === 0)  continue;
                    let enable = true;
                    for(let j = 0; j <3;j++){
                        if(splitWall[posX-1][posY+j] !== '.') enable = false;
                    }
                    if(splitWall[posX][posY+1] !== '.') enable = false;
                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }

                if(i === 2){
                    if(posX === 0)  continue;
                    let enable = true;
                    if(splitWall[posX-1][posY] !== '.') enable = false;
                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }

                if(i === 3){
                    if(posX === 0)  continue;
                    let enable = true;
                    for(let j = 0; j < 4;j++){
                        if(splitWall[posX-1][posY-j] !== '.') enable = false;
                    }
                    if(splitWall[posX][posY-1] !== '.') enable = false;
                    if(splitWall[posX][posY-2] !== '.') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }

                if(i === 4){
                    if(posX === 0)  continue;
                    let enable = true;
                    for(let j = 0; j <4;j++){
                        if(splitWall[posX-1][posY+j] !== '.') enable = false;
                    }
                    if(splitWall[posX][posY+1] !== '.') enable = false;
                    if(splitWall[posX][posY+2] !== '.') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }

                if(i === 5){
                    if(posX === 0)  continue;
                    let enable = true;
                    
                    if(splitWall[posX][posY-1] !== '.') enable = false;
                    if(splitWall[posX-1][posY] !== '.') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }

                if(i === 6){
                    if(posX === 0)  continue;
                    let enable = true;
                    if(splitWall[posX][posY+1] !== '.') enable = false;
                    if(splitWall[posX-1][posY] !== '.') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }
                if(i === 7){
                    if(posX === 0)  continue;
                    let enable = true;
                    if(splitWall[posX-1][posY] !== 'H') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }
                if(i === 8){
                    let enable = true;
                    if(splitWall[posX+1][posY] !== 'H') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }
                if(i === 9){
                    let enable = true;
                    if(splitWall[posX][posY-1] !== 'H') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }
                if(i === 10){
                    let enable = true;
                    if(splitWall[posX][posY+1] !== 'H') enable = false;

                    if(enable){
                        queue.push([posX+moveX[i],posY + moveY[i]]);
                        answer[posX+moveX[i]][posY + moveY[i]] = Math.min(count,answer[posX+moveX[i]][posY + moveY[i]] === 0 ? count : answer[posX+moveX[i]][posY + moveY[i]] );
                    }
                    else{
                        console.log('Cant');
                    }
                }
        }
        }
    }

    for(let i = 0; i < N; i++){
        for(let j = 0; j < M; j++){
            if(answer[i][j] === 0 && splitWall[i][j] === 'H'){
                answer[i][j] = -1;
            }
        }
    }

    // console.table(splitWall);
    console.table(answer);
    
    // return answer;
}

// console.log(solution(["H..H", "....", "H..H"])); 
console.log(solution(["H.H", ".HX", "H.H"])); 
console.log(solution(["....HH", "H..H.H"])); 