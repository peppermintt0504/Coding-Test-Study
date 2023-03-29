function solution(park, routes) {
    var answer = [];
    let pos =[0,0];
    const h = park.length;
    const w = park[0].length;
    park.forEach((v,i)=>{
        if(v.includes('S')){
            pos = [i,v.indexOf("S")]
        }
    })
    
    const direction = {
        N : [-1,0],
        S : [1,0],
        W : [0,-1],
        E : [0,1],
    }
    
    routes.forEach((v,i)=>{
        let [d, n] = v.split(' ');
        const dir = direction[d].map((v)=>v*n);
        const nextPos = [pos[0] + dir[0], pos[1] + dir[1]];
        if(nextPos[0] >= h || nextPos[0] < 0 || nextPos[1] >= w || nextPos[1] < 0){
            return
        }
        
        for(let i = 1; i <= n; i++){
            const tempPosH = pos[0] + direction[d][0]*i;
            const tempPosW = pos[1] + direction[d][1]*i;
            if(park[tempPosH][tempPosW] === 'X'){
                return
            }
        }
        pos = nextPos;
    })
    
    
    return pos;
}