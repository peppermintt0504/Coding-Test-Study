function solution(numer1, denom1, numer2, denom2) {
    var answer = 
        [
            numer1 * (getLCM(denom1,denom2) / denom1) + numer2 * (getLCM(denom1,denom2) / denom2) 
            ,getLCM(denom1,denom2)
        ];
    answer = answer.map((v)=>v/getGCD(answer[0],answer[1]))
    return answer;
}

const getGCD = (a,b) =>{
    return b ===0 ? a : getGCD(b,a%b)
}
const getLCM = (a,b) => {
    return a * b / getGCD(a,b);
}