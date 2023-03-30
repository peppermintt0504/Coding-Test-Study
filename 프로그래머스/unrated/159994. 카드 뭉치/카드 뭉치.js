function solution(cards1, cards2, goal) {
    for(word of goal){
        if(cards1[0] === word){
            cards1.shift();
            continue;
        }
        if(cards2[0] === word){
            cards2.shift();
            continue;
        }
        return 'No'
    }
    return 'Yes'
}