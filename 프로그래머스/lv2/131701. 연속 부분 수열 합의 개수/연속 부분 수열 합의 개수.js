function solution(elements) {
    var answer = 0;
    const elementsLength = elements.length;
    const sumList = {};
    
    for(let i = 1; i <= elements.length; i++){
        for(let n = 0; n < elements.length; n++){
            let sum = 0;
            for(j = 0; j < i; j++){
                sum += elements[(n + j) % elementsLength];
            }
            if(!sumList[sum]){
                answer++;
                sumList[sum] = true;
            }
        }
    }
    return answer;
}