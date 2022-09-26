const calcDate = (A,B) =>{
    let tempY = A[0] - B[0];
    let tempM = A[1] - B[1];
    let tempD = A[2] - B[2];

    if(tempM < 1) {
        tempY -= 1;
        tempM += 12;
    }
    if(tempD < 1) {
        tempM -= 1;
        tempD += 28;
    }
    return [tempY,tempM,tempD]
}


function solution(today, terms, privacies) {
    var answer = [];
    let expireTerms = {};
    const [yy,mm,dd] = today.split('.').map(Number);
    terms.map((v)=>{
        const [T1,T2] = v.split(' ');
        expireTerms[T1] = Number(T2);
    })
    // console.log(expireTerms,yy,mm,dd);

    for(let i = 0; i < privacies.length; i++){
        const [date, term] = privacies[i].split(' ');
        const [y,m,d] = date.split('.').map(Number);
        const timeData = calcDate([yy,mm,dd],[y,m,d])
        let expire = expireTerms[term] * 28;

        if(expire <= (timeData[0]*12*28 + timeData[1]*28 + timeData[2])){
            answer.push(i+1);
        }


    }

    return answer;
}

console.log(
    solution("2022.05.19", ["A 6", "B 12", "C 3"], ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"])
)