function solution(cap, n, deliveries, pickups) {
    let answer = 0;
    let delSum = deliveries.reduce((a,b)=>a+b,0);
    let pickSum = pickups.reduce((a,b)=>a+b,0);
    
    while(delSum !== 0 || pickSum !== 0){
        deleteZero(deliveries);
        deleteZero(pickups);
        let len = Math.max(deliveries.length, pickups.length);
        answer += len*2;
        delSum -= delItem(deliveries, cap);
        pickSum -= delItem(pickups, cap);
    }
    return answer;
}

const deleteZero = (arr)=>{
    for(let i=arr.length-1; i>=0; i--){
        if(arr[i] === 0) arr.pop();
        else return;
    }
}

const delItem = (arr,cap) =>{
    let cnt = 0;
    for(let i=arr.length-1; i>=0; i--){
        if(arr[i] >= cap){
            arr[i] -= cap;
            cnt += cap;
            break;
        } 
        else{
            cap -= arr[i];
            cnt += arr[i];
            arr[i] = 0;
        } 
    }
    return cnt;
}