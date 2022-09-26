
const quickSort = (arr) =>{
    if(arr.length < 2)  return arr;
    
    const pivot = arr[0];
    const left = [];
    const right = [];

    for(let i = 1; i < arr.length; i++){
        if(arr[i] < pivot)  left.push(arr[i]);
        else    right.push(arr[i]);
    }

    return [...quickSort(left),pivot,...quickSort(right)]
}


function solution(edges, target) {
    var answer = [];
    let node = {};
    let nodeCount = [];
    let total = Array(target.length).fill(0);
    for(let i = 0; i < edges.length; i++){
        if(node[edges[i][0]]){
            node[edges[i][0]] = [...node[edges[i][0]],edges[i][1]];
        }else{
            node[edges[i][0]] = [edges[i][1]];
            nodeCount.push(edges[i][0]);
        }
    }
    for(let i = 0; i < nodeCount.length; i++){
        node[nodeCount[i]] = quickSort(node[nodeCount[i]]);
    }

    const dropNum = (pos)=>{
        if(!node[pos]){
            return pos
        }
        const down = node[pos].shift();
        node[pos].push(down);

        return dropNum(down);
    }

    let count = 20
    let start = 1
    while(count){
        count --;
        const thisTime = dropNum(start)-1;
        if(total[thisTime] !== target[thisTime]){
            let rest = (target[thisTime] - total[thisTime]) % 3;
            let val =  Math.floor((target[thisTime] - total[thisTime]) / 3);
            console.log('target : ',thisTime+1,'>>',total[thisTime],'->',target[thisTime],val,rest);

            if(target[thisTime] === 0){

            }
            if(rest === 0){
                console.log('answer->',3);
                total[thisTime] += 3;
                answer.push(3);
            }else{
                console.log('answer->',rest);
                total[thisTime] += rest;
                answer.push(rest);
            }
        }
        if(total === target)break;
    }


    return answer;
}

console.log(
    solution([[2, 4], [1, 2], [6, 8], [1, 3], [5, 7], [2, 5], [3, 6], [6, 10], [6, 9]], [0, 0, 0, 3, 0, 0, 5, 1, 2, 3])
)