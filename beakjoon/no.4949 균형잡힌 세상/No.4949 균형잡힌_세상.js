const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`So when I die (the [first] I will see in (heaven) is a score list).
[ first in ] ( first out ).
Half Moon tonight (At least it is better than no Moon at all].
A rope may form )( a trail in a maze.
Help( I[m being held prisoner in a fortune cookie factory)].
([ (([( [ ] ) ( ) (( ))] )) ]).
 .
.`).split('\n');

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
        return this.size !== 0 ?this.top.item : 0;
    }
    clear(){
        this.top = null;
        this.size = 0;
    }
}

    
function solution(){
    let line = input();
    let str = '';
    let stack = new Stack();
    let answer = 'yes';

    while(line !== '.'){
        stack.clear();
        answer = 'yes'
        str += line;
        if(str[str.length-1] ==='.'){
            for(let c of str){
                if(c === '('){
                    stack.push('(');
                }
                if(c === '['){
                    stack.push('[');

                }
                if(c === ')'){
                    if(stack.getTop() !== '('){
                        answer = 'no';
                        break;
                    }else{
                        stack.pop();
                    }
                }
                if(c === ']'){
                    if(stack.getTop() !== '['){
                        answer = 'no';
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            answer = stack.getSize() === 0 ? answer : 'no';
            console.log(answer);
            str = '';
        }
        line = input();
    }
}

solution();