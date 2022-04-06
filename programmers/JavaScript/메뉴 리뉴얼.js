function combination(arr, selectNum) {
    const result = [];
    if (selectNum === 1) return arr.map((v) => [v]);
    arr.forEach((v, idx, arr) => {
        const fixed = v;
        const restArr = arr.slice(idx + 1);
        const combinationArr = combination(restArr, selectNum - 1);
        const combineFix = combinationArr.map((v) => [fixed, ...v]);
        result.push(...combineFix);
    });
    return result;
}

function solution(orders, course) {
    let answer = [];
    let menu = {};

    orders.forEach(order=>{
        course.forEach(num =>{
            let set = combination(order.split(''),num)
            set.forEach(setMenu=>{
                let m = setMenu.sort().join("");
                if(menu[m]) menu[m]++;
                else    menu[m] =1;
            })
        })
    })
    course.forEach(num =>{
        let best = [];
        let max = 2;
        for(key in menu){
            if(key.length === num){
                if(menu[key] === max){
                    best.push(key);
                }
                if(menu[key] > max){
                    best=[key];
                    max = menu[key]
                }
            }
        }
        best.length!==0?answer=[...answer,...best]:null;
    })
    return answer.sort();
}