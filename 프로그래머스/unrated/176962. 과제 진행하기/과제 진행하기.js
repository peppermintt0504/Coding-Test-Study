function solution(plans) {
    var answer = [];
    let queue = [];
    let curTime = 0;
    let endTime = 0;
    
    for(i in plans){
        plans[i][1] = getTime(plans[i][1]);
        plans[i][2] = Number(plans[i][2]);
    }
        
    plans.sort((a,b)=>a[1]-b[1]);
    
    for(i in plans){
        // console.log(plans[i],'>');
        // console.log('queue : ',queue);
        // console.log('curTime : ',curTime);
        // console.log('endTime : ',endTime);
        // console.log('answer : ',answer);
        
        if(queue.length === 0){
            queue.push(plans[i]);
            curTime = plans[i][1];
            endTime = curTime + plans[i][2]
        }else{
            if(plans[i][1] >= endTime){
                answer.push(queue.pop()[0]);
                let doingTime = plans[i][1] - endTime;
                while(doingTime && queue.length){
                    if(queue[queue.length - 1][2] <= doingTime){
                        doingTime -= queue[queue.length - 1][2];
                        answer.push(queue.pop()[0]);
                    }else{
                        queue[queue.length - 1][2] -= doingTime;
                        doingTime = 0;
                    }
                }
                queue.push(plans[i]);
                curTime = plans[i][1];
                endTime = curTime + plans[i][2]
            }else{
                queue[queue.length - 1][2] -= plans[i][1] - curTime;
                queue.push(plans[i]);
                curTime = plans[i][1];
                endTime = curTime + plans[i][2];
            }
        }
    }
    
    while(queue.length){
        answer.push(queue.pop()[0])
    }
    
    return answer;
}

function getTime(time) {
    const [hh,mm] = time.split(':').map(Number);
    return hh*60 + mm;
}