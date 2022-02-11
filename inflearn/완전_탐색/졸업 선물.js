function solution(N,M,std) {
    let sum = 0;
    let count = 0;
    let answer = [];
    for(let i = 0; i < N; i++){
        let temp = JSON.parse(JSON.stringify(std));
        temp[i][0] = temp[i][0] / 2
        temp.sort((a,b)=> {return (a[0]+a[1])-(b[0]+b[1])});
        sum = 0;
        count = 0;
        
        for(let j = 0; j < N;j++){
            sum += temp[j][0] +temp[j][1];
            if(sum > M){
                answer.push(count);
                break;
            }else{
                count += 1;
            }

        }
    }

    return Math.max(...answer);

}

const N = 5;
const M = 28;
const std = [[6,6],[2,2],[4,3],[4,5],[10,3]]

console.log(solution(N,M,std));
