function solution(queue1, queue2) {
    var answer = 0;
    const tempQueue = queue1.concat(queue2);
    let q1Sum = queue1.reduce((x,v)=>x+v,0);
    let q2Sum = queue2.reduce((x,v)=>x+v,0);
    let start = 0;
    let end = queue1.length;
    
    while(q1Sum !== q2Sum){
        if(start === tempQueue.length -1)   return -1;
        if(end === queue1.length - 1)   return -1;
        
        if(q1Sum > q2Sum){
            q1Sum -= tempQueue[start];
            q2Sum += tempQueue[start];
            start++;
        }else{
            q1Sum += tempQueue[end];
            q2Sum -= tempQueue[end];
            end = end + 1 % tempQueue.length;
        }
    
        answer++
        
        if(answer > tempQueue.length * 2) return -1;
    }
    
    
    return answer;
}