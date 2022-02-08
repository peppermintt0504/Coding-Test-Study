function solution(list) {
    let answer= [];
    let std = list[0];
    let prob= list[1];
    let rank = list[2];

    let cheak = true;

    for(let i = 0; i < std;i++){
        for(let j = 0; j < std; j++){
            if(i===j)
                continue;
            cheak = true;

            for(let c = 0; c < prob; c++){
                if(rank[c].indexOf(i+1) > rank[c].indexOf(j+1)){
                    cheak = false;
                    break;
                }
            }
            cheak?answer.push([i+1,j+1]):"";
        }
    }

    return answer
}

console.log(solution([4,3,[[3, 4, 1, 2], [4, 3, 2, 1],[3, 1, 4, 2]]]));