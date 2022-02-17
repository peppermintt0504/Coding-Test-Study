function solution(n,m) {
    let answer = [];
    
    for(let i of n){
        if(m.includes(i))
            answer.push(i);
    }

    return answer.sort((a,b)=> a-b);

}

const n = [1,3,9,5,2];
const m = [3,2,5,7,8];

console.log(solution(n,m));