function solution(n, t, m, p) {
    var answer = '';
    let temp = '';
    let num = 0
    
    while((temp.length / m) < t){
        temp += num.toString(n).toUpperCase();
        num++;
    }
    temp = temp.split("");
    for(let i = 0; i < t; i++){
        answer += temp[p - 1 + i * m];
    }
    
    return answer;
}