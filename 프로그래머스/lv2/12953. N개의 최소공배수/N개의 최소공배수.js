function solution(arr) {
    var answer = 0;
    let lcm = arr.shift();
    
    arr.forEach((x)=>{
        lcm = getLCM(lcm,x);
    })
    
    return lcm;
}

const getGCD = (a, b) => a % b === 0 ? b : getGCD(b, a % b);
const getLCM = (a, b) => a * b / getGCD(a, b);

