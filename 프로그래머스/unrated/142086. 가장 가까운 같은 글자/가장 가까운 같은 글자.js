function solution(s) {
    let answer = [];
    const counter = {};
    for(i in s){
        if(counter[s[i]]){
            answer.push(i - counter[s[i]]);
            counter[s[i]] = i;
        }else{
            answer.push(-1);
            counter[s[i]] = i;
        }
    }
    return answer;
}