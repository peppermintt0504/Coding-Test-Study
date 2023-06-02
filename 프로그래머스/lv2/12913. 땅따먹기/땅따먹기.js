function solution(land) {
    var answer = 0;

    const dp = Array.from({length : land.length + 1}, ()=>Array(4).fill(Number.MIN_VALUE));
    
    for(let i = 1; i <= land.length; i++){
        for(let j = 0; j < 4; j++){
            dp[i][j] = dp[i-1].reduce((x,v,index)=>{
                if(index === j) return x;
                return Math.max(x,v)
            },0) + land[i-1][j];
        }
    }
    return Math.max(...dp[land.length]);
}