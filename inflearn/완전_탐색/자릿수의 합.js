function solution(s) {
    let answer = 0;
    let max = 0;
    
    for(let i in s){
        let temp = String(s[i]).split("");
        let sum = temp.reduce((x,v,i) => {return x + parseInt(v)},0)

        if(max < sum ){
            answer = s[i];
            max = sum;
        }
        else if( max === sum ){
            answer = answer >= s[i]? answer : s[i];
        }
    }

    return answer;

}

console.log(solution([128, 460, 603, 40, 521, 137, 123]));
console.log(solution([235,1234]));
console.log(solution([235,1234,9001]));
