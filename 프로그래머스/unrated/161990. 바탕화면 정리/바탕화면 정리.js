function solution(wallpaper) {
    var answer = [];
    let maxX = 0;
    let minX = 50;
    let maxY = 0;
    let minY = 50;
    
    wallpaper.forEach((val,i)=>{
        for(let j = 0; j < val.length; j++){
            if(val[j] === '#'){
                maxX = Math.max(maxX, j);
                minX = Math.min(minX, j);
                maxY = Math.max(maxY, i);
                minY = Math.min(minY, i);
            }
        }
    })
    return [minY,minX,maxY+1,maxX+1];
}