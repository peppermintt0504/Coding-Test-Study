function sol(s,t) { 
    let pos = []
    let answer = [];
    for(let i in s)
        if(s[i]===t)
            pos.push(parseInt(i));
    
    for(let i in s){
        let temp = [];
        for(let p of pos){
            temp.push(Math.abs(p - i));
        }
        answer.push(Math.min(...temp))
    }
    return answer;
}
console.log(sol("teachermode", "e"))