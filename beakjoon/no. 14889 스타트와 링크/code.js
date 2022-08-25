const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`8
0 5 4 5 4 5 4 5
4 0 5 1 2 3 4 5
9 8 0 1 2 3 1 2
9 9 9 0 9 9 9 9
1 1 1 1 0 1 1 1
8 7 6 5 4 0 3 2
9 1 9 1 9 1 0 9
6 5 4 3 2 1 9 0`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

const getCombination = (arr,size)=>{
    const results = [];

    if(size === 1) return arr.map((v)=>[v])

    arr.forEach((fixed,index,origin)=>{
        const rest = origin.slice(index+1);
        const combination = getCombination(rest,size-1);
        const attached = combination.map((combination) => [fixed, ...combination]);
        results.push(...attached);
    })
    return results;
}
function solution(){
    let data = [];
    let people = [];
    let answer = Number.MAX_VALUE;
    let N = input();
    for(let i = 0; i < N; i++){
        people.push(i);
        const inputData = input().split(" ").map((a)=>+a);
        data.push(inputData);
    }
    let teamA = [];
    teamA = getCombination(people,N/2);
    for(let i = 0; i < teamA.length; i++){
    // for(let i = 0; i < 2; i++){
        const teamB = people.filter((v)=>!teamA[i].includes(v))
        const teamAScore = teamA[i].reduce((V,player)=>{
            const score = teamA[i].reduce((v,cur)=>{
                if(player===cur) return v;

                // console.log('data[',player,cur,']',data[player][cur])
                return data[player][cur] + v
            },0)

            return V + score
        },0)
        // console.log('teamAScore',teamAScore);
        const teamBScore = teamB.reduce((V,player)=>{
            const score = teamB.reduce((v,cur)=>{
                if(player===cur) return v;

                // console.log('data[',player,cur,']',data[player][cur])
                return data[player][cur] + v
            },0)

            return V + score
        },0)
        // console.log('teamBScore',teamBScore);

        // console.log(Math.abs(teamAScore-teamBScore))
        // console.log(totalScoreA,totalScoreB)
        answer = answer>Math.abs(teamAScore-teamBScore) ? Math.abs(teamAScore-teamBScore) : answer
    }
    console.log(answer);
}

solution();
