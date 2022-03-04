const fs = require('fs');
const stdin = (process.platform === 'linux'
    ? fs.readFileSync('/dev/stdin').toString()
    :
`15
push 1
push 2
front
back
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
front`
).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];
})();

class Node {
    constructor(item){
        this.item = item;
        this.next = null;
    }
}

class Queue {
    constructor(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    push(item){
        const node = new Node(item);
        if(!this.head){
            this.head = node;
            this.head.next = this.tail;
        }else{
            this.tail.next = node;
        }
        this.tail = node;
        this.size += 1;
    }

    getSize(){
        return this.size;
    }
    pop(){
        if(this.size > 2){
            const item = this.head.item;
            const newHead = this.head.next;
            this.head = newHead;
            this.size -= 1;
            return item;
        }else if (this.size === 2){
            const item = this.head.item;
            const newHead = this.head.next;
            this.head = newHead;
            this.tail = newHead;
            this.size -= 1;
            return item;
        }else if (this.size === 1){
            const item = this.head.item;
            this.head = null;
            this.tail = null;
            this.size -= 1;
            return item;
        }else{
            return -1;
        }
    }
    empty(){
        return this.size ? 0:1;
    }
    front(){
        return this.head ? this.head.item : -1;
    }
    back(){
        return this.tail ? this.tail.item : -1;
    }
}

let line = input()
let queue = new Queue();
let result = [];

while(line){
    const commend = input().split(' ');
    switch (commend[0]){

        case "push":
            queue.push(commend[1]);
            break;

        case "pop":
            result.push(queue.pop());
            break;

        case "size":
            result.push(queue.getSize());
            break;

        case "empty":
            result.push(queue.empty());
            break;

        case "front":
            result.push(queue.front());
            break;

        case "back":
            result.push(queue.back());
            break;
        }
    line -= 1;
}

console.log(result.join('\n'));