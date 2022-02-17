function solution(N,M) {
    let list1 = N;
    let list2 = M;
    
    let answer = [];
    console

    while(list1.length !==0 & list2.length !==0){
        if(list1[0] >= list2[0]){
            answer.push(list2.shift());
        }
        else{
            answer.push(list1.shift());
        }
    }

    if(list1.length===0)
        answer= [...answer,...list2];
    
    if(list2.length === 0)
        answer= [...answer,...list1];
    
    




    return answer;

}

const N = [1, 3, 5]
const M = [2, 3, 6, 7, 9]

console.log(solution(N,M));