function solution(t, p) {
    let answer = 0;
    const subLength = p.length;
    for(let i = 0; i <= t.length-subLength; i++){
        const target = Number(t.slice(i,i+subLength));
        if(target<=p){
            answer++;
        }
    }
    return answer;
}