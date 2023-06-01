const isPrime =  ( num ) => {
    if(num < 2)     return false;
    if(num === 2)   return true;
    
    for(let i = 3; i <= Math.sqrt(num); i += 2){
        if(num % i === 0) return false;
    }
    
    return true;
}

function solution(n, k) {
    var answer = 0;
    const convertNum = n.toString(k);
    const numList = convertNum.split('0').filter((x)=> x !== '');
    numList.forEach((x)=>{
        isPrime(x) && answer++
    })
    return answer;
}