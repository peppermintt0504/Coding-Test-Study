function solution(board) {
    let totalO = [];
    let totalX = [];
    
    board.forEach((v,i)=>{
        for(j in v){
            if(v[j] === 'O'){
                totalO.push([i,j]);
            }
            else if(v[j] === 'X'){
                totalX.push([i,j])
            }
        }
    })
    
    if(totalX.length > totalO.length || totalO.length - totalX.length > 1) return 0;
    if(checkWin(board,'O') && checkWin(board,'X'))  return 0;
    if(checkWin(board,'O') && totalX.length >= totalO.length)  return 0;
    if(checkWin(board,'X') && totalX.length !== totalO.length)  return 0;
    return 1;
}

const checkWin = (board,target) =>{
    if(board.includes(target.repeat(3))){
        return true;
    }else if(board[0][0] === target && board[1][1] === target && board[2][2] === target){
        return true;
    }else if(board[2][0] === target && board[1][1] === target && board[0][2] === target){
        return true;
    }
    for(let i = 0; i < 3; i++){
        if(board[0][i] === target && board[1][i] === target && board[2][i] === target){
            return true;
        }
    }
    return false
        
}