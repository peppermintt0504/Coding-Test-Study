function solution(brown, yellow) {
    var answer = [];
    let length = (brown + 4) / 2;
    let row = 3;
    while(1){
        const col = length - row;
        if((col-2) * (row-2) === yellow)    break;
        else                                row++;
    }
    
    return [length - row, row];
}