const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`10
5 50
4 40
3 30
2 20
1 10
1 10
2 20
3 30
4 40
5 50`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


const searchData = (date, schedule, pay)=>{
    const arrayPay = []
    if(date > schedule.length-1){
        return [pay]
    }
    // console.log('date :',date)
    // console.log(date + schedule[date][0],schedule,schedule[date][1]+pay);
    const doWork = searchData(date + schedule[date][0],schedule,date + schedule[date][0]<=schedule.length ?schedule[date][1]+pay : pay)
    const doNotWork = searchData(date + 1,schedule,pay)
    
    // console.log('date :',date,'doWork',doWork)
    // console.log('date :',date,'doNotWork',doNotWork)
    return [...arrayPay,...doWork,...doNotWork];
}
function solution(){
    let data = [];
    let N = input();
    for(let i = 0; i < N; i++){
        const inputData = input().split(" ").map((a)=>+a);
        data.push([inputData[0],inputData[1]]);
    }
    // console.log(data);
    const AllCase = searchData(0,data,0);
    console.log(Math.max(...AllCase));
    // for(let i = 0; i < N; i++){
    //     let date = 0;
    //     //work
    //     for(let j= 0; j < N; j++){
            
    //     }

    //     //do not work
    //     for(let j= 0; j < N; j++){
            
    //     }
    // }
}

solution();
