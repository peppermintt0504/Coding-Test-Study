function solution(s) {
    let answer = 0;
    let target = '';
    let targetCount = 0;
    let count = 0;
    
    for(x of s){
        if(target === ''){
            target = x;
            targetCount = 1;
            continue;
        }
        
        if(x === target){
            targetCount++;
        }else{
            count++;
        }
        
        if(targetCount === count){
            answer++;
            target = '';
            targetCount = 0;
            count = 0;
        }
    }
    if(target !== '')   answer++;
    
    return answer;
}