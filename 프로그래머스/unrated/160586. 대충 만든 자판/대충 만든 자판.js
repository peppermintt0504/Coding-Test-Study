function solution(keymap, targets) {
    let memo = {};
    
    let answer =targets.map((target,i)=>{
        let count = 0;
        
        for(v of target){
            if(memo[v]){
                count += memo[v];
            }else{
                const minCount = keymap.map((key)=>{
                    return key.indexOf(v) + 1;
                }).filter((v)=>v !== 0);
                if(minCount.length === 0) return -1
                memo[v] = Math.min(...minCount)
                count += memo[v];
            }
        }
        
        return count;
    })
    
    
    return answer;
}
