function solution(name, yearning, photo) {
    var answer = [];
    const yearningScore = {};
    name.forEach((target,i)=>{
        yearningScore[target] = yearning[i];
    })
    photo.forEach((target)=>{
        answer.push(target.reduce((x,v)=>yearningScore[v]? x+yearningScore[v] : x,0))
    })
    return answer;
}