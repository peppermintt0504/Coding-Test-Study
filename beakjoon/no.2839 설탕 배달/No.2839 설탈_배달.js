const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    : 
`11`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();


let total = input(); //배달 무게

//5kg을 최대한 많이 넣은 경우에서부터 하나도 넣지 않을 경우를 제시한다
//이 사이에 남은 설탕의 무게가 3의 배수라면 그 조합이 최소한으로 배달가능한 조합이다.
for(let i = 0; i <= parseInt(total/5); i++){
		//5kg을 배달하고 남은 설탕 무게
    let temp = total - (parseInt(total/5) - i) * 5; 
		//남은 무게가 3의 배수라면 출력하고 종료한다.
    if(temp%3===0){
        console.log(parseInt(total/5) - i + temp/3);
        return;
    }
}
//모든 경우 해당이 되지 않을 경우 -1을 출력하고 종료한다.
console.log(-1)
return;