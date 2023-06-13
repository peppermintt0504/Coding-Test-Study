function solution(scores) {
    const wanho = scores[0];
    // 근무태도점수 내림차순정렬, 근무태도 동점일 경우 동료평가점수 오름차순 정렬
    scores.sort((a,b) => a[0] === b[0] ? a[1] - b[1] : b[0] - a[0]);
    let answer = 1;
    let maxScore = 0;
    const wanhoSum = wanho[0] + wanho[1];
    
    for(let score of scores){
        // 내 앞의 동료평가점수가 나보다 높은 사람이 한 사람이라도 있으면 탈락
        // 근무태도 동점자의 경우 동료평가점수 오름차순 정렬 되어있으므로 고려할 필요X
        if(score[1] < maxScore) {
            // 탈락대상
            if(score === wanho) return -1;
        } else {
            // 인센대상
            maxScore = Math.max(maxScore, score[1]);
            if(score[0] + score[1] > wanhoSum){
                answer++;
            }
        }
    }
    return answer;
}