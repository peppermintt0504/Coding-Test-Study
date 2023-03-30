function solution(s, skip, index) {
    var answer = '';
    const list = Array(26).fill(true);
    for(k of skip){
        list[k.charCodeAt(0) - 97] = false;
    }
    
    s.split('').forEach((v,i)=>{
        let code = v.charCodeAt(0)-97;
        let skipCount = 0;
        while(skipCount !== index){
            const next = (code + 1) % 26;
            if(list[next]){
                skipCount++;
            }
            code = next;
        }
        answer += String.fromCharCode(code+97)
    })
    return answer;
}