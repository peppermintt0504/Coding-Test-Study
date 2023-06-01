function solution(s) {
    var answer = 0;
    let str = s.split('');
    const open = ['(','[','{'];
    const close = [')',']','}'];
    for(let i = 0; i < str.length; i++){
        const temp = str.shift();
        str.push(temp);
        
        let openKind = [];
        let result = true;
        
        for(let n = 0; n < str.length; n++){
            if(open.includes(str[n])){
                openKind.push(open.indexOf(str[n]));
            }else{
                if(openKind.length){
                    if(openKind[openKind.length - 1] === close.indexOf(str[n])){
                        openKind.pop();
                    }
                }else{
                    result = false;
                    break;
                }
            }
        }
        if(result && openKind.length === 0)  answer++;
    }
    return answer;
}