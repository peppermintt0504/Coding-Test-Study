function solution(weights) {
    var answer = 0;
    const balance = [1,3/2,4/2,4/3];
    const memo = new Map();
    
    weights.sort((a,b)=>b-a);
    
    for(let i = 0 ; i < weights.length ;i++){
        for(x of balance){
            if(memo.has(weights[i] * x)){
                answer += memo.get(weights[i] * x);
            }
        }
        memo.set(weights[i] ,(memo.get(weights[i]) || 0) + 1);
    }
    
    return answer;
}