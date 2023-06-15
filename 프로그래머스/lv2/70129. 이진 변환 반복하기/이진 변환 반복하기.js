function solution(s) {
    var answer = [0,0];
    let num = s;
    
    while(num !== '1'){
        const zeroCount = num.split('').reduce((x,v)=>v === '0' ? x+1 : x,0);
        answer[1] += zeroCount;
        answer[0]++;
        
        num = (num.length - zeroCount).toString(2);
    }
    return answer;
}