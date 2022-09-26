function solution(cap, n, deliveries, pickups) {
    var answer = 0;
    let deliveriesCount = deliveries.reduce((x,v)=>x+v);
    let pickupsCount = pickups.reduce((x,v)=>x+v);
    let total = [];
    // console.log(deliveriesCount);
    // console.log(pickupsCount);
    let count = 1;
    while(count){
        let onBoarding = 0;
        
        for(let i = 0; i < n;i++){
            // console.log(i+1,'집');
            // console.log(deliveries[n-1-i]," : ", pickups[n-1-i])
            const DT = Math.ceil(deliveries[n-1-i] / cap);
            let extraD = deliveries[n-1-i] % cap;
            const PT = Math.ceil(pickups[n-1-i] / cap);
            let extraP = pickups[n-1-i] % cap;
            // console.log("DT : ",DT)
            // console.log("extraD : ",extraD)
            // console.log("PT : ",PT)
            // console.log("extraP : ",extraP)

            
            total.push([DT,PT]);
            for(let j = i+1; j < n;j++){
                if(deliveries[n-1-j] <= extraD){
                    extraD -= deliveries[n-1-j];
                    deliveries[n-1-j] = 0;
                }
                if(pickups[n-1-j] <= extraP){
                    extraP -= pickups[n-1-j];
                    pickups[n-1-j] = 0;
                }
            }
        }
        count --;
    }
    // console.table(total);
    for(let i = 0; i < n;i++){
        const small = Math.min(...total[i]);
        const big = Math.max(...total[i],0);
        // console.log(big , n-i , 2)
        answer += (big * (n-i) * 2);
        // console.log(answer);
        if(i !== n-1){
            if(total[i][0] < big){
                total[i+1][0] += total[i][0] - big
            }
            if(total[i][1] < big){
                total[i+1][1] += total[i][1] - big
            }
        }
        // console.table(total);
    }
    return answer;
}
// console.log(
//     solution(4, 5, [0, 3, 0, 4, 0],[1, 0, 3, 1, 2])
// )
// console.log(
//     solution(4, 5, [1, 0, 3, 1, 2], [0, 3, 0, 4, 0])
// )
console.log(
    solution(2, 7, [1, 0, 2, 0, 1, 0, 2], [0, 2, 0, 1, 0, 2, 0])
)
