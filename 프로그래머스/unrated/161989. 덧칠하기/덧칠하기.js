function solution(n, m, section) {
    let result = 0;
    let endPoint = 0;
    section.forEach((v,i)=>{
        if(v > endPoint){
            endPoint = v + m -1;
            result++;
        }
    })
    
    return result;
}