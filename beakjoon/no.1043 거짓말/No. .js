const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`4 3
0
2 1 2
1 3
3 2 3 4`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();


    
function solution(){
    let [people, party] = input().split(' ').map(v=>+v);
    let truth = input().split(' ').map(v=>+v);
    if(truth.shift()===0){
        console.log(party);
        return;
    }
    let count = party;

    let record = [];


    while(party){
        party -= 1;

        let participant = input().split(' ').map(v=>+v);
        participant.shift();
        record.push(participant);
        for(a of participant){
            if(truth.includes(a)){
                for(t of participant){
                    if(truth.includes(t))
                        continue;
                    truth.push(t);
                }
                break;
            }
        }
        
    }
    

    while(1){
        result = count;
        let compare = truth.length;

        for(i of record){
            for(a of i){
                if(truth.includes(a)){
                    result -= 1;
                    for(t of i){
                        if(truth.includes(t))
                            continue;
                        truth.push(t);
                    }
                    break;
                }
            }
        }
        
        if(compare === truth.length){
            break;
        }
    }
    console.log(result);
}

solution();