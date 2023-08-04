function solution(s) {
    var answer = '';
    let min = Number.MAX_VALUE;
    let max = -10000000;
    
    let temp = "";
    
    for(str of s.split(" ")){
        if(max < parseInt(str)) max = parseInt(str);
        if(min > parseInt(str)) min = parseInt(str);
    }
    
    return min + " " + max;
}