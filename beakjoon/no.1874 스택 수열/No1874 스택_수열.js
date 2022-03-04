const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`5
1
2
5
3
4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

class Node {
    constructor(item){
        this.item = item;
        this.next = null;
    }
}

class Stack {
    constructor(){
        this.top = null;
        this.size = 0;
    }

    push(item){
        const node =new Node(item);
        
        if(this.top){
            node.next = this.top;
            this.top = node;
        }else{
            this.top = node;
        }
        this.size += 1;
    }

    pop(){
        if(this.size >= 2){
            const item = this.top.item;
            const newTop = this.top.next;
            this.top = newTop;
            this.size -= 1;
            return item;
        }
        else if(this.size === 1){
            const item = this.top.item;
            this.top = null;
            this.size -= 1;
            return item;
        }else{
            return -1;
        }
    }

    getSize(){
        return this.size;
    }
}

let stack = new Stack;
let line = input();
let arr = [];
let answer = [];

for(let i = 0; i < line; i++)
    arr.push(i+1);

while(line){
    line -= 1;
    const num = parseInt(input());
    if(arr.includes(num)){
        let count = arr.indexOf(num)+1;
        for(let i = 0; i < count; i++){
            stack.push(arr.shift());
            answer.push('+');
        }
    }

    const count = stack.getSize();
    let tempArr = [];
    
    for(let i = 0; i < count; i++){
        let temp = stack.pop();
        tempArr.push(temp);
        answer.push('-');
        if(num === temp){
            break;
        }
    }

    if(!tempArr.includes(num)){
        console.log('NO');
        return;
    }
}
console.log(answer.join('\n'));
