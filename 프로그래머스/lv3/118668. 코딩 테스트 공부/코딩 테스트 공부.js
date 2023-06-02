function solution(alp, cop, problems) {
    var answer = 0;
    let maxAlp = alp;
    let maxCop = cop;
    
    problems.forEach((p)=>{
        const [reqAlp,reqCop,rwdAlp,rwdCop,cost] = p;
        maxAlp = Math.max(maxAlp,reqAlp);
        maxCop = Math.max(maxCop,reqCop);
    })
    let dp = Array.from({length : maxCop + 2},()=> Array(maxAlp + 2).fill(Number.MAX_VALUE));
    dp[cop][alp] = 0;
    
    for(let i = cop; i <= maxCop; i++){
        for(let j = alp; j <= maxAlp; j++){
            
            if(cop < maxCop)dp[i+1][j] = Math.min(dp[i][j]+1,dp[i+1][j]);
            if(alp < maxAlp) dp[i][j+1] = Math.min(dp[i][j]+1,dp[i][j+1]);
            
            problems.forEach((p)=>{
                const [reqAlp,reqCop,rwdAlp,rwdCop,cost] = p;
                if(reqAlp <= j && reqCop <= i){
                    const tempCop = Math.min(maxCop, i+rwdCop);
                    const tempAlp = Math.min(maxAlp, j+rwdAlp);
                    dp[tempCop][tempAlp] = Math.min(dp[i][j]+cost,dp[tempCop][tempAlp]);
                }
            })
            
            
            
        }
    }
    
    return dp[maxCop][maxAlp];
}