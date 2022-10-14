const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
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
front`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


function solution() {
    const N = Number(input());
    let answer ='';
    let store = [];
    for(let i = 0;  i < N; i++){
        const commend = input().split(" ");
        switch(commend[0]){
            case 'push' : 
                store.push(commend[1]);
                break;
            case 'pop' :
                if(store.length === 0){
                    answer += '-1\n';
                    break;
                }else{
                    answer += store.shift() + "\n";
                    break;
                }
            case 'size':
                answer += store.length + "\n";
                break;
            case 'empty' : 
                if(store.length === 0){
                    answer += '1\n';
                    break;
                }else{
                    answer += '0\n';
                    break;
                }
            case 'back' : 
                if(store.length === 0){
                    answer += '-1\n';
                    break;
                }else{
                    answer += store[store.length-1] +'\n';
                    break;
                }
            case 'front' : 
                if(store.length === 0){
                    answer += '-1\n';
                    break;
                }else{
                    answer += store[0] +'\n';
                    break;
                }
        }
        
    }
    console.log(answer.trim());
}


solution();
