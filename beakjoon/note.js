const fs = require('fs');
const stdin = (process.platform === 'linux'? fs.readFileSync('/dev/stdin').toString() :
`7 7
#######
#.....#
#.#####
#.....#
#####.#
#O.R.B#
#######`).split('\n');

const input = (() => {
    let line = 0;
    return () => stdin[line++];})();

    
function solution(){
    let data = [];
    let [C, R] = input().split(' ');
    let red = [0,0];
    let blue = [0,0];
    let answer = 99;
    const toRight = (count)=>{
        let tempData = '';
        for(let i = 1; i < C-1; i++){

            if(red[0]=== i && blue[0] === i){
                if(red[1] > blue[1]){
                    for(let j = red[1] + 1; j < R; j++){
                        if(data[i][j] === 'O'){
                            console.log('GOOD!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'B'){
                            tempData=data[i];
                            tempData=tempData.replace('R','.');
                            tempData = (tempData.slice(0,j-1)+'R'+tempData.slice(j));
                            data[i] = tempData;
                            red = [i,j-1];
                            break;
                        }
                    }
                    for(let j = blue[1] + 1; j < R; j++){
                        if(data[i][j] === 'O'){
                            console.log('FUCK!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'R'){
                            tempData=data[i];
                            tempData=tempData.replace('B','.');
                            tempData = (tempData.slice(0,j-1)+'B'+tempData.slice(j));
                            data[i] = tempData;
                            blue = [i,j-1];
                            break;
                        }
                    }
                }else{
                    for(let j = blue[1] + 1; j < R; j++){
                        if(data[i][j] === 'O'){
                            console.log('FUCK!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'R'){
                            tempData=data[i];
                            tempData=tempData.replace('B','.');
                            tempData = (tempData.slice(0,j-1)+'B'+tempData.slice(j));
                            data[i] = tempData;
                            blue = [i,j-1];
                            break;
                        }
                    }
                    for(let j = red[1] + 1; j < R; j++){
                        if(data[i][j] === 'O'){
                            console.log('GOOD!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'B'){
                            tempData=data[i];
                            tempData=tempData.replace('R','.');
                            tempData = (tempData.slice(0,j-1)+'R'+tempData.slice(j));
                            data[i] = tempData;
                            red = [i,j-1];
                            break;
                        }
                    }
                }
            }
            else if(red[0]=== i && !(blue[0] === i)){
                for(let j = red[1] + 1; j < R; j++){
                    if(data[i][j] === 'O'){
                        console.log('GOOD!');
                        return;
                    }else if(data[i][j]  === '#' || data[i][j] === 'B'){
                        tempData=data[i];
                        tempData=tempData.replace('R','.');
                        tempData = (tempData.slice(0,j-1)+'R'+tempData.slice(j));
                        data[i] = tempData;
                        red = [i,j-1];
                        break;
                    }
                }
            }
            else if(!(red[0]=== i) && blue[0] === i){
                for(let j = blue[1] + 1; j < R; j++){
                    if(data[i][j] === 'O'){
                        console.log('FUCK!');
                        return;
                    }else if(data[i][j]  === '#' || data[i][j] === 'R'){
                        tempData=data[i];
                        tempData=tempData.replace('B','.');
                        tempData = (tempData.slice(0,j-1)+'B'+tempData.slice(j));
                        data[i] = tempData;
                        blue = [i,j-1];
                        break;
                    }
                }
            }

        }
        console.log(data,red,blue);
        return count+1
    }
    const toLeft = (red,blue,count)=>{
        let tempData = '';
        for(let i = 1; i < C-1; i++){
            if(red[0]=== i && blue[0] === i){
                if(red[1] < blue[1]){
                    for(let j = red[1]; j >= 0; j--){
                        if(data[i][j] === 'O'){
                            console.log('GOOD!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'B'){
                            tempData=data[i];
                            tempData=tempData.replace('R','.');
                            tempData = (tempData.slice(0,j+1)+'R'+tempData.slice(j+2));
                            data[i] = tempData;
                            red=[i,j+1];
                            break;
                        }
                    }
                    for(let j = blue[1]; j >= 0; j--){
                        if(data[i][j] === 'O'){
                            console.log('FUCK!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'R'){
                            tempData=data[i];
                            tempData=tempData.replace('B','.');
                            tempData = (tempData.slice(0,j+1)+'B'+tempData.slice(j+2));
                            data[i] = tempData;
                            blue=[i,j+1];
                            break;
                        }
                    }
                }else{
                    for(let j = blue[1]; j >= 0; j--){
                        if(data[i][j] === 'O'){
                            console.log('FUCK!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'R'){
                            tempData=data[i];
                            tempData=tempData.replace('B','.');
                            tempData = (tempData.slice(0,j+1)+'B'+tempData.slice(j+2));
                            data[i] = tempData;
                            blue=[i,j+1];
                            break;
                        }
                    }
                    for(let j = red[1]; j >= 0; j--){
                        if(data[i][j] === 'O'){
                            console.log('GOOD!');
                            return;
                        }else if(data[i][j]  === '#' || data[i][j] === 'B'){
                            tempData=data[i];
                            tempData=tempData.replace('R','.');
                            tempData = (tempData.slice(0,j+1)+'R'+tempData.slice(j+2));
                            data[i] = tempData;
                            red=[i,j+1];
                            break;
                        }
                    }
                }
            }
            else if(red[0]=== i && !(blue[0] === i)){
                for(let j = red[1]; j >= 0; j--){
                    if(data[i][j] === 'O'){
                        console.log('GOOD!');
                        return;
                    }else if(data[i][j]  === '#' || data[i][j] === 'B'){
                        tempData=data[i];
                        tempData=tempData.replace('R','.');
                        tempData = (tempData.slice(0,j+1)+'R'+tempData.slice(j+2));
                        data[i] = tempData;
                        red=[i,j+1];
                        break;
                    }
                }
            }
            else if(!(red[0]=== i) && blue[0] === i){
                for(let j = blue[1]; j >= 0; j--){
                    if(data[i][j] === 'O'){
                        console.log('FUCK!');
                        return;
                    }else if(data[i][j]  === '#' || data[i][j] === 'R'){
                        tempData=data[i];
                        tempData=tempData.replace('B','.');
                        tempData = (tempData.slice(0,j+1)+'B'+tempData.slice(j+2));
                        data[i] = tempData;
                        blue=[i,j+1];
                        break;
                    }
                }
            }

        }
        console.log(data);
        return count+1
    }
    for(let i = 0; i < C; i++){
        data.push(input());
        if(data[i].includes('R')){
            console.log([i,data[i].indexOf('R')]);
            red=[i,data[i].indexOf('R')];
        }
        if(data[i].includes('B')){
            console.log([i,data[i].indexOf('B')])
            blue=[i,data[i].indexOf('B')];
        }
    }
    // console.log(data);
    toRight(red,blue,0);
    toLeft(red,blue,0);


}

solution();
