function solution(n, lost, reserve) {
    let answer = 0;
    
    const newLost = lost.filter((lost)=>!reserve.includes(lost)).sort((a,b)=>a-b);
    const newReserve = reserve.filter((reserve)=>!lost.includes(reserve));
    const used = []
    newLost.forEach((lost,i)=>{
        if(newReserve.includes(lost - 1) && !used.includes(lost - 1)){
            answer++;
            used.push(lost - 1);
        }else if(newReserve.includes(lost + 1) && !used.includes(lost + 1)){
            answer++;
            used.push(lost + 1);
        }
    })
    return n - newLost.length + answer
}