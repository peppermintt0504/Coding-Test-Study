function solution(n) {
    var answer = 0;
    let visited = Array(n).fill(0);
    
    DFS(n,[]);
    
    
    return count;
}

let count = 0;

function DFS(n,stack) {
    if(stack.length == n){
        count++;
        return
    }
    
    for(let i = 0; i < n; i++){
        let cant = false;
        for(let j = 0; j < stack.length;j++){
            if(stack[j] === i || stack[j] + (stack.length - j) === i || stack[j] - (stack.length - j) === i){
                cant = true;
                break;
            }
            
        }
        if(!cant){
            DFS(n,[...stack,i]);
        }
    }
}