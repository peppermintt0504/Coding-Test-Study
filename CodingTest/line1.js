function solution(){
    queries = [[2, 10], [7, 1], [2, 5], [2, 9], [7, 32]];
    var answer = 0;
    let data = {};
    for(let i = 0; i < queries.length; i++){
        if(!data[queries[i][0]]){
            let size = 1;
            while(size < queries[i][1]){
                size *= 2;
            }
            data[queries[i][0]] = {
                size : size,
                cur : queries[i][1],
            };
        }else{
            if(data[queries[i][0]].cur + queries[i][1] > data[queries[i][0]].size){
                console.log("???",data[queries[i][0]].cur);
                let size = 1;
                let totalSize = data[queries[i][0]].cur + queries[i][1];
                answer += data[queries[i][0]].cur;
                while(size < data[queries[i][0]].cur + queries[i][1]){
                    size *= 2;
                }
                data[queries[i][0]] = {
                    size : size,
                    cur : totalSize,
                };
            }else{
                data[queries[i][0]].cur = data[queries[i][0]].cur + queries[i][1];
            }
        }
    }
    
    console.log(data);
    console.log(answer);
    return answer;
}

solution(); 