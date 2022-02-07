function solution(s){
    let answer="";
    let top = -1;
    let count = 1;
    
    for(let i in s){
        if(answer ===""){
            answer = answer + s[i];
            top += 1;
            continue;
        }
        if(answer[top] === s[i]){
            count += 1;
            continue;
        }else{
            if(count === 1){
                answer = answer + s[i];
                top += 1;
            }else{
                answer = answer + String(count) + s[i];
                top += 2;
                count = 1;
            }
        }
    }
    if(count !== 1)
        answer = answer + String(count);   
    return answer;
}

console.log(solution("KKHSSSSSSSE"));
console.log(solution("GGGEDSSEFEE"));
console.log(solution("AAAAAAAA"));

