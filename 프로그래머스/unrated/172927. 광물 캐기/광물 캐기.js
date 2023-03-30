function solution(picks, minerals) {
    let result = 0;
    const taskCost = [];
    const mineralList = minerals.slice(0,5*picks.reduce((x,v)=>x+v,0));
    const mineralCost = {
        diamond : {
            diamond : 1,
            iron : 1,
            stone : 1
        },
        iron : {
            diamond : 5,
            iron : 1,
            stone : 1
        },
        stone : {
            diamond : 25,
            iron : 5,
            stone : 1
        },
    }
    for(let i = 0; i < Math.ceil(mineralList.length / 5,0); i++){
        const task = mineralList.slice(i*5,i*5+5);
        const cost = task.reduce((x,v)=>{
            return x + mineralCost.stone[v];
        },0);
        taskCost.push([cost,task]);
    }

    taskCost.sort((a,b)=>-a[0]+b[0])
    taskCost.forEach((v)=>{
        let usePick = '';
        if(picks[0]){
            usePick = 'diamond';
            picks[0]--;
        }else{
            if(picks[1]){
                usePick = 'iron';
                picks[1]--;
            }else{
                usePick = 'stone';
                picks[2]--;
            }
        }
        v[1].forEach((val)=>{
            result += mineralCost[usePick][val];
        })
    })
    return result;
}