const fs = require('fs');
//백준
const input = fs.readFileSync('/dev/stdin').toString();
//VSCode
//const input = fs.readFileSync('예제.txt').toString();

let answer = '';
for (let i = 1; i < Number(input) + 1; i++) {
	answer += i + '\n';
}
console.log(answer);

