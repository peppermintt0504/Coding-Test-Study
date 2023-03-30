function solution(today, terms, privacies) {
    let answer = [];
    const expired = {}
    const todayDays = getDays(today);
    terms.forEach((v)=>{
        const [type, term] = v.split(' ');
        expired[type] = Number(term) * 28;
    })
    
    privacies.forEach((v,i)=>{
        const [date, type] = v.split(' ');
        const days = getDays(date) + expired[type];
        if(todayDays >= days)   answer.push(i+1);
    })
    
    return answer;
}

function getDays (Date) {
    const [YY,MM,DD] = Date.split(' ')[0].split(".").map(Number);
    return ((YY-2000) * 12 + MM) * 28 + DD;
}