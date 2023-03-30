function solution(k, score) {
    let answer = [];
    let part = [];
    let min = 0;
    
    score.forEach((s,i)=>{
        if(part.length < k){
            part.push(s);
            min = Math.min(...part);
            answer.push(min);
            return
        }
        if(s > min){
            part.push(s);
            part = part.slice(0,part.indexOf(min)).concat(part.slice(part.indexOf(min)+1,part.length));
            min = Math.min(...part)
        }
        answer.push(min);
    })
    
    return answer;
}