function solution(){
    queries = [[2, 10], [7, 1], [2, 5], [2, 9], [7, 32]];
    var answer = -1;
    let data = {};
    console.log(queries);
    for(let i = 0; i < queries.length; i++){
        data[queries[i][0]] = queries[i][1];
    }
    return answer;
}

solution(); 