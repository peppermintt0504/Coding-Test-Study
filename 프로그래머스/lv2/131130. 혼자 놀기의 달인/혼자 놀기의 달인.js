function solution(cards) {
    var answer = 0;
    cards.forEach((c)=>{
        const box1 = [];
        let target = c;
        while(!box1.includes(target)){
            box1.push(target);
            target = cards[target - 1];
        }
        const remainedCards = cards.filter((x)=>!box1.includes(x));
        
        const maxCard2 = remainedCards.reduce((x,v)=>{
            const box2 = [];
            target = v;
        
            while(!box2.includes(target)){
                box2.push(target);
                target = cards[target - 1];
            }
            return Math.max(x,box2.length);
        },0)           
        
        answer = Math.max(answer, maxCard2 * box1.length)
    })
    return answer;
}