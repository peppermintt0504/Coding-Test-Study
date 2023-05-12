function solution(k, tangerine) {
    var answer = 0;
    let count = 0;
    const size = {};
    const sizeList = [];
    
    tangerine.forEach((v)=>{
        size[v] ? size[v]++ : size[v] = 1;
    })
    for([key, val] of Object.entries(size)){
        sizeList.push([key,val]);
    }
    
    sizeList.sort((a,b)=>b[1] - a[1]);
    
    
    while(count<k){
        const [key,val] = sizeList.shift();
        
        count+=val;
        answer++;
    }
    return answer;
}