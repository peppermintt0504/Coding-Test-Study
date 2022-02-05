function sol(s) { 
    let reg = /[0-9]/;
    let answer = 0;

    for(let c of s)
        if(reg.test(c))
            answer = answer*10 + parseInt(c) 
    return answer;
}
console.log(sol("g0en2T0s8eSoft"))