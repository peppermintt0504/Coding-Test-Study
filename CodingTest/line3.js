function solution(n, m, fires, ices) {
    let world = Array.from({length : n},()=>Array(n).fill(0));

    for(let i = 0; i < n; i++){
        for(let j = 0; j < n; j++){
            fires.map((v)=>{
                const range = Math.max(Math.abs(i-(v[0]-1)),Math.abs(j-(v[1]-1)))
                world[i][j] += Math.max(m - range + 1,0);
                if(range === 0) world[i][j] -= 1;
            })
            ices.map((v)=>{
                const range = Math.abs(i-(v[0]-1)) + Math.abs(j-(v[1]-1))
                world[i][j] += Math.min(-m + range -1,0);
                if(range === 0) world[i][j] += 1;

            })
        }
    }
    return world;
}

console.log(solution(3, 2, [[1, 1]], [[3, 3]])); 
console.log(solution(5, 3, [[5, 5], [1, 3], [5, 2]], [[1, 5], [3, 2]])); 