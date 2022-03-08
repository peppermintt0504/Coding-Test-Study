const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`3
((
))
())(()`).split('\n');

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
        getTop(){
            return this.top.item;
        }
        clear(){
            this.top = null;
            this.size = 0;
        }
    }

    

function solution(){
    let line = input();
    let stack = new Stack();

    while(line){
        line -= 1;
        let answer = 'YES'
        let data = input();
        stack.clear();
        for(let i = 0; i < data.length; i++){
            if(data[i] === '('){
                stack.push('(');
            }else{
                if(stack.getSize() !== 0){
                    stack.pop();
                }
                else{
                    answer = 'NO';
                    break;
                }
            }
        }
        console.log(stack.getSize() === 0?answer:'NO');

    }
}

solution();