function solution(k, dic, chat){
    var answer = '';

    let chatArr = chat.split(' ');
    
    for(let i = 0; i < chatArr.length; i++){
        let slpitWord = chatArr[i].split('.');
        let wordLength = chatArr[i].length;
        let dotCount = chatArr[i].split("").reduce((x,v)=> v === '.'?x+1:x,0);


        for(let j = 0; j < dic.length; j++){
            let isSlang = false;
            let tempCount = 0;
            if(dic[j].length < wordLength)  continue;
            slpitWord.map((v)=>{
                if(dic[j].includes(v)){
                    tempCount += 1;
                }
            })
            if(tempCount === slpitWord.length){
                if(dic[j].length - (wordLength - dotCount) <= dotCount * k){
                    let temp = '';
                    for(let z = 0; z < wordLength;z++)  temp +='#';
                    chatArr[i] = temp;
                }
            }
        }

    }
    chatArr.map((v)=>{answer = answer + v + " "})
    return answer.slice(0,answer.length-1);
}

console.log(solution(2, ["slang", "badword"], "badword ab.cd bad.ord .word sl.. bad.word")); 
console.log(solution(3, ["abcde", "cdefg", "efgij"], ".. ab. cdefgh .gi. .z.")); 