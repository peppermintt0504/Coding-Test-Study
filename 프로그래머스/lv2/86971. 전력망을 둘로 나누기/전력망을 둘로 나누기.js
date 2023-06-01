function countLink (link,start) {
    let answer = 0;
    const queue = [start];
    const list = [start];
    while(queue.length){
        const target = queue.shift();
        link[target].forEach((x)=>{
            if(list.includes(x))    return;
            list.push(x);
            queue.push(x);
        })
    }
    return list.length;
}


function solution(n, wires) {
    var answer = n;
    const link = {};
    wires.forEach(([a,b])=>{
        if(link[a]){
            link[a].push(b);
        }else{
            link[a] = [b];
        }
        if(link[b]){
            link[b].push(a);
        }else{
            link[b] = [a];
        }
    })
    
    wires.forEach(([a,b])=>{
        const tempLink = {...link};
        tempLink[a] = tempLink[a].filter((x)=>x!==b);
        tempLink[b] = tempLink[b].filter((x)=>x!==a);
        
        const result = Math.abs(countLink(tempLink,a) - countLink(tempLink,b));
        if(answer > result) answer = result;        
    })
    return answer;
}