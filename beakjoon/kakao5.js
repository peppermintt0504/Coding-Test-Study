function solution(commands) {
    var answer = [];
    let board = Array.from({length:51},()=>Array(51).fill(''));
    let keywords = {};
    let marges = [['40 1', '1 2', '42 11'],['1 3', '2 7']];

    for(let i = 0; i < commands.length; i++){
        console.log(commands[i]);
        const thisCommand = commands[i].split(' ');
        if(thisCommand[0] === 'UPDATE'){
            //
            if(thisCommand.length === 4){
                board[thisCommand[1]][thisCommand[2]] = thisCommand[3];
                const thisMarge = marges.filter((v,i)=>{
                    if(v.includes(thisCommand[1] + ' ' + thisCommand[2])){
                        pos = i;
                        return true;
                    }else{
                        return false;
                    }
                })[0]
                thisMarge?.map((v)=>{
                    const [a,b] = v.split(' ');
                    board[a][b] = thisCommand[3];
                })
                // if(keywords[thisCommand[3]]){
                //     let tempStr = ''
                //     tempStr = thisCommand[1]+' '+thisCommand[2]
                //     keywords[thisCommand[3]] = [...keywords[thisCommand[3]],tempStr]
                // }else{
                //     let tempStr = ''
                //     tempStr = thisCommand[1]+' '+thisCommand[2]
                //     keywords[thisCommand[3]] = [tempStr]
                // }
            }
            //
            else{
                // const arr = keywords[thisCommand[1]];
                // keywords[thisCommand[1]] = [];
                
                // arr.map((v)=>{
                //     const [a,b] = v.split(' ');
                //     board[a][b] = thisCommand[2];
                // })

                // if(keywords[thisCommand[2]]){
                //     keywords[thisCommand[2]] = [...keywords[thisCommand[2]],...arr]
                // }else{
                //     keywords[thisCommand[2]] = [...arr]
                // }
                for(let i = 1; i <= 50; i++){
                    for(let j = 1; j <= 50; j++){
                        if(board[i][j] === thisCommand[1])  board[i][j] = thisCommand[2];
                    }
                }
                // console.log(thisCommand[1],'->',thisCommand[2],keywords[thisCommand[2]])
            }
        }

        if(thisCommand[0] === 'MERGE'){
            let data = '';           
            let strArr = [thisCommand[1]+' '+thisCommand[2],thisCommand[3]+' '+thisCommand[4]];
            if(board[thisCommand[1]][thisCommand[2]] === '' && board[thisCommand[3]][thisCommand[4]] !== '')
                data = board[thisCommand[3]][thisCommand[4]];
            else
                data = board[thisCommand[1]][thisCommand[2]];
            
            let already = false;

            let margeData = marges.filter((v)=>{
                if(v.includes(strArr[0]) || v.includes(strArr[1])){
                    already = true;
                    return true;
                }else{
                    return false;
                }
                
            })

            let addMarge = [];
            margeData.map((v)=>{
                addMarge = addMarge.concat(v);
            })
            if(!addMarge.includes(strArr[0]))addMarge.push(strArr[0])
            if(!addMarge.includes(strArr[1]))addMarge.push(strArr[1])

            console.log(data);
            console.log(strArr);
            console.log(margeData);
            console.log(addMarge);

            addMarge.map((v)=>{
                const [a,b] = v.split(' ');
                board[a][b] = data;
            })

            marges = [...marges.filter((v)=>{
                if(v.includes(strArr[0]) || v.includes(strArr[1])){
                    return false;
                }else{
                    return true;
                }
                
            }),addMarge]
        }

        if(thisCommand[0] === 'UNMERGE'){
            let str = thisCommand[1]+' '+thisCommand[2];
            let pos = 0;
            const thisMarge = marges.filter((v,i)=>{
                if(v.includes(str)){
                    pos = i;
                    return true;
                }else{
                    return false;
                }
            })[0]
            // console.log(thisMarge);
            
            thisMarge?.map((v)=>{
                if(v !== str){
                    const [a,b] = v.split(' ');
                    board[a][b] = '';
                }   
            })

            marges = [...marges.slice(0,pos-1),...marges.slice(pos+1,marges.length)];
            // console.log(marges);
        }

        if(thisCommand[0] === 'PRINT'){
            answer.push(board[thisCommand[1]][thisCommand[2]] === ''? 'EMPTY' : board[thisCommand[1]][thisCommand[2]])
        }
    }
    // console.table(board);
    // console.log(keywords);
    return answer;
}

console.log(
    solution(["UPDATE 50 50 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"])
)
// console.log(
//     solution(["UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"])
// )