const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

let line = input()
let stack = [];
let result = [];

while(line){
    const commend = input().split(' ');
    switch (commend[0]){

        case "push":
            stack.push(commend[1]);
            break;

        case "pop":
            result.push(stack.length !== 0?stack.pop():'-1');
            break;

        case "size":
            result.push(stack.length);
            break;

        case "empty":
            result.push(stack.length === 0?'1':'0');
            break;

        case "top":
            result.push(stack.length === 0?'-1':stack[stack.length-1]);
            break;
    }
    line -= 1;
}

console.log(result.join('\n'));