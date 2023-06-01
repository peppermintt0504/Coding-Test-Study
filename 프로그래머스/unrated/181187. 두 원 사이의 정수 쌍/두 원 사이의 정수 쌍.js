function solution(r1, r2) {
    let answer = 0;
    let axis = 0;
    
    for(let y = 0; y <= r2; y++){
        let maxX = Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(y,2)));
        let minX = Math.ceil(Math.sqrt(Math.max(0,Math.pow(r1,2) - Math.pow(y,2))));
        if(minX === 0) axis++;
        if(y === 0) axis += maxX - minX + 1;
        
        answer += maxX - minX + 1;
    }
    return 4 * answer - 2 * axis;
}