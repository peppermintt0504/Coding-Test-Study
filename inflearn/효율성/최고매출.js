function solution(n,k,m) {
    let answer = [];
    let max = 0;
    
    for(let i in m){
        if(i<k){
            answer.push(m[i])
            max = answer.reduce((x,v)=>x+=v,0);
            continue;
        }
        answer.shift();
        answer.push(m[i]);
        const sum = answer.reduce((x,v)=>x+=v,0);
        
        if(max < sum)
            max= sum    
    }
    return max;

}

const n = 10;
const k = 3;
const m = [12,15,11,20,25,10,20,19,13,15];

console.log(solution(n,k,m));