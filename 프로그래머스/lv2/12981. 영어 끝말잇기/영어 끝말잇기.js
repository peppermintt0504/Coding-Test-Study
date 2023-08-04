function solution(n, words) {
    let savedLastWord = words[0].slice(0,1)
    const passWords = []
    let answer = [0,0]

    words.every((word,idx)=>{
        // 중복단어 사용 
        if(passWords.includes(word)){
            answer = [ idx % n + 1, Math.floor((idx) / n) + 1]
            return false
        }
        // 끝말잇기 실패 
        if(word[0].slice(0,1) !== savedLastWord){
            answer = [ idx % n + 1, Math.floor((idx) / n) + 1]
            return false
        }
        savedLastWord = word.slice(-1)
        passWords.push(word)
        return true
    })

    return answer
}