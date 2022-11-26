const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`500000
8
0 2 3 4 6 7 8 9`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();





const target = Number(input())
const c = Number(input());
const wrongBtn = c === 0 ? [] : input().split(' ').map(Number);
const btn = [0,1,2,3,4,5,6,7,8,9].filter((v)=>!wrongBtn.includes(v));
let answer = Math.abs(target - 100);

const makeNum = (num, digit) =>{
    if(num.toString().length >= digit){
        const temp = Math.abs(num - target) + digit;
        if(answer > temp){
            answer = temp;
        }
        return;
    }else{
        btn.map((v)=>{
            makeNum( (num*10) + v, digit);
        })
    }
}

btn.filter((v)=> v!==0).map((v)=>{

    for(let a = target.toString().length+1; a >=1;a--){
        makeNum(v,a);
    }
})

if(btn.includes(0)){
    const temp = Math.abs(0 - target) + 1;
    if(answer > temp){
        answer = temp;
    }
}


console.log(answer);






// let stillGood = true;
// let canUp = true;
// let canDown = true;
// let up = 0;
// let down = 0;

// target.toString().split('').map((v,i)=>{
//     const num = Number(v)
//     if(stillGood){
//         if(wrongBtn.includes(num)){
//             let upNumber = num;
//             let downNumber = num;
//             stillGood = false;
//             while(wrongBtn.includes(upNumber)){
//                 upNumber++;
//                 if(upNumber === 10){
//                     canUp = false;
//                     break;
//                 }
//             }
//             while(wrongBtn.includes(downNumber)){
//                 downNumber--;
//                 if(downNumber === -1){
//                     canDown = false;
//                     break;
//                 }
//             }
//             if(canUp){
//                 up *= 10;
//                 up += upNumber;
//             }
//             if(canDown){
//                 down *= 10;
//                 down += downNumber;
//             }

//         }else{
//             if(canUp){
//                 up *= 10;
//                 up += num;
//             }
//             if(canDown){
//                 down *= 10;
//                 down += num;
//             }         
//         }
//     }else{
//         if(canUp){
//             up *= 10;
//             up += Math.min(...btn);
//         }
//         if(canDown){
//             down *= 10;
//             down += Math.max(...btn);
//         }
//     }
// })
// console.log(down)
// console.log(canUp? up-target + target.toString().length : Number.MAX_VALUE , canDown ? target-down + target.toString().length : Number.MAX_VALUE ,Math.abs(100-target))
// console.log(Math.min(canUp? up-target + target.toString().length : Number.MAX_VALUE , canDown ? target-down + target.toString().length : Number.MAX_VALUE ,Math.abs(100-target)))