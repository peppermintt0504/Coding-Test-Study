function solution(m, n, startX, startY, balls) {
    var answer = [];
    
    const rightWall = ([a,b],[x,y]) =>{
        if(b === y && a < x) return Number.MAX_VALUE;
        return Math.pow(a-(2 * m - x),2)+Math.pow(b-y,2);
    }
    const leftWall = ([a,b],[x,y]) =>{
        if(b === y && a > x) return Number.MAX_VALUE;
        return Math.pow(a+x,2)+Math.pow(b-y,2)
    }
    const upWall = ([a,b],[x,y]) =>{
        if(a === x && b < y) return Number.MAX_VALUE;
        return Math.pow(a-x,2)+ Math.pow(b-(2 * n - y),2)
    }
    const downWall = ([a,b],[x,y]) =>{
        if(a === x && b > y) return Number.MAX_VALUE;
        return Math.pow(a-x,2)+Math.pow(b+y,2)
    }
    
    balls.forEach((ball) => {
        answer.push(Math.min(
        rightWall([startX,startY],ball),
        leftWall([startX,startY],ball),
        upWall([startX,startY],ball),
        downWall([startX,startY],ball)))
    })
    return answer;
}