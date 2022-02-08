function solution(s) {
    let list =[];
    let answer = [];
    let cheak = true;

    for(let i = 0; i< s.length; i++)
        list.push(parseInt(String(s[i]).split("").reverse().join("")));
    
    
    for(i = 0; i <list.length; i++){
        cheak = true;
        if(list[i] === 1)
            continue;
        for(j=2; j <= parseInt(Math.sqrt(list[i])); j++){ 
            if(list[i] % j == 0){
                cheak = false; 
                break;
            }
        }
        if(cheak === true)
            answer.push(list[i]);
    }
    
    return answer;

}

console.log(solution([32, 55, 62, 20, 250, 370, 200, 30, 100]));