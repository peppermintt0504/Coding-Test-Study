function solution(expression) {
    var answer = 0;
    const calcList = [];
    let temp = '';
    const oper = ['+','-','*'];
    const operCase = [
        ['+','-','*'],
        ['+','*','-'],
        ['-','+','*'],
        ['-','*','+'],
        ['*','-','+'],
        ['*','+','-'],
    ]
    for(let i = 0; i < expression.length; i++){
        if(oper.includes(expression[i])){
            calcList.push(Number(temp));
            calcList.push(expression[i]);
            temp = '';
        }else{
            temp += expression[i];
        }
    }
    calcList.push(Number(temp));
    
    operCase.forEach((c)=>{
        let tempList = [...calcList];
        
        for(let i = 0; i < 3; i++){
            while(tempList.includes(c[i])){
                const index = tempList.indexOf(c[i]);
                switch(c[i]){
                    case '+' : {
                        tempList = [...tempList.slice(0,index-1),tempList[index-1] + tempList[index+1],...tempList.slice(index+2,tempList.length)];
                        break;
                    }
                    case '-' : {
                        tempList = [...tempList.slice(0,index-1),tempList[index-1] - tempList[index+1],...tempList.slice(index+2,tempList.length)];
                        break;
                    }
                    case '*' : {
                        tempList = [...tempList.slice(0,index-1),tempList[index-1] * tempList[index+1],...tempList.slice(index+2,tempList.length)];
                        break;
                    }
                }
            
            }    
                        
        }
        if(answer < Math.abs(tempList[0]))  answer = Math.abs(tempList[0]);
        
    })
    
    return answer;
}