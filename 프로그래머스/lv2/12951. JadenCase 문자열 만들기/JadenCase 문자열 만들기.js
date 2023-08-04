function solution(s) {
    var answer = '';
    let nextIsFirst = false;
    s.split("").forEach((c,i)=>{
        if(i === 0){
            answer+= c.toUpperCase();
            return
        }
        
        if(c === " "){
            nextIsFirst = true;
            answer += " ";
            return
        }
        if(nextIsFirst){
            answer+= c.toUpperCase();
            nextIsFirst = false;
        }else{
            answer+= c.toLowerCase();
        }
    })
    return answer;
}