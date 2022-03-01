// const input = require("fs").readFileSync("/dev/stdin").toString().trim().split(/\s/);
const input = ["8","4 1 6 1 3 6 1 4"];
const N = input[0];
const A = input[1].split(" ").map(v=> parseInt(v));

let answer = Array.from({ length: N });
let count = 0;

for(let i = 0; i < N ; i++){
    const minNum = Math.min(...A);
    const index = A.indexOf(minNum);
    answer[index] = count;
    count += 1;
    A[index] = 1001;
}


console.log(answer.join(" "));

