function solution(order) {
    var answer = 0;
    let cur = 0;
    let inTruck = 0;
    const stack = [];
    for(let i = 0; i < order.length; i++){
        const target = order[inTruck];
        if(cur + 1 <= target){
            for(let j = cur; j < target - 1; j++){
                stack.push(j+1);
            }
            inTruck++;
            cur = target;
        }else{
            if(stack.length !== 0 && stack[stack.length-1] === target){
                stack.pop();
                inTruck++;
            }else{
                break;
            }
        }
        // console.log(stack);
        // console.log(inTruck);
    }
    return inTruck;
}