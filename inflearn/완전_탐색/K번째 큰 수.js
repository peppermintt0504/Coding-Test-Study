function solution(N,K,list) {
    
    let sorted_list = list.sort((a,b) => a-b);
    let sum_list = [];
    
    for(let i = 0; i < N; i++){
        for(let j = i+1; j < N; j++){
            for(let r = j+1; r < N; r++){
                sum_list.push(list[i] + list[j] + list[r]);
            }
        }
    }
    return sum_list.sort((a,b) => -a+b)[K-1];
}

const N = 10;
const K = 3;
const list = [13, 15, 34, 23, 45, 65, 33, 11, 26, 42];

console.log(solution(N,K,list));