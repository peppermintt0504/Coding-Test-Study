function convertToMin (time) {
    const [h, m] = time.split(':').map(Number);
    return h*60 + m;
}

function solution(fees, records) {
    var answer = [];
    const [init, initFee, per, fee] = fees;
    const list = {};
    const visitList = {};
    
    records.forEach((x)=>{
        const [time, number,kind] = x.split(' ');
        if(kind === 'IN'){
            list[number] = convertToMin(time);
        }else{
            const parkingTime = convertToMin(time) - list[number];
            if(visitList[number])   visitList[number] += parkingTime;
            else                    visitList[number] = parkingTime;
            delete list[number];
        }
    })
    for([key,val] of Object.entries(list)){
        const parkingTime = convertToMin('23:59') - val;
        if(visitList[key])   visitList[key] += parkingTime;
        else                    visitList[key] = parkingTime;
    }
    
    
    for([key,val] of Object.entries(visitList)){
        let thisFee = initFee;
        if(val > init) thisFee += Math.ceil((val - init)/ per) * fee;
        answer.push([key,thisFee]);
    }
    answer.sort((a,b)=>a[0]-b[0]);
    return answer.map((x)=>x[1]);
}