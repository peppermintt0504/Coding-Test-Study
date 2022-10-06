function solution(n, m, x, y, r, c, k) {
    var answer = '';
    const moveX = x-r;
    const moveY = y-c;
    x--;
    y--;
    r--;
    c--;
    let obj = {
        d :( moveX < 0 ? -moveX : 0),
        l : (moveY > 0 ? moveY : 0),
        u : (moveX > 0 ? moveX : 0),
        r : (moveY < 0 ? -moveY : 0),
    }
    if((k - Math.abs(moveX) - Math.abs(moveY)) % 2 || k < Math.abs(moveX) + Math.abs(moveY)){return 'impossible'}

    let coin = (k - Math.abs(moveX) - Math.abs(moveY)) / 2;
    for(let i = 0; i < k;i++){
        // console.log(x,y,':',r,c)
        if(x + 1 < n){
            if(obj.d > 0){
                // console.log('하')
                x = x + 1;
                obj.d -= 1;
                answer += 'd';
                continue;
            }else{
                if(coin !== 0){
                    coin -= 1;
                    obj.u += 1;
                    x = x + 1;
                    answer += 'd';
                    continue;
                }
            }
        }
        
        if(y - 1 >= 0){
            if(obj.l > 0){
                // console.log('좌')
                y = y - 1;
                obj.l -= 1;
                answer += 'l';
                continue;
            }else{
                if(coin !== 0){
                    coin -= 1;
                    obj.r += 1;
                    y = y - 1;
                    answer += 'l';
                    continue;
                }
            }
        }

        if(y + 1 < m){
            if(obj.r > 0){
                // console.log('우')
                y = y + 1;
                obj.r -= 1;
                answer += 'r';
                continue;
            }else{
                if(coin !== 0){
                    coin -= 1;
                    obj.l += 1;
                    y = y + 1;
                    answer += 'r';
                    continue;
                }
            }
        }
        if(x - 1 >= 0){
            if(obj.u > 0){
                // console.log('상')
                x = x - 1;
                obj.u -= 1;
                answer += 'u';
                continue;
            }else{
                if(coin !== 0){
                    coin -= 1;
                    obj.d += 1;
                    x = x - 1;
                    answer += 'u';
                    continue;
                }
            }
        }
        
    }

    return answer;
}

console.log(
    solution(3, 4, 2, 3, 3, 1, 5)
)
console.log(
    solution(2, 2, 1, 1, 2, 2, 2)
)
console.log(
    solution(3, 3, 1, 2, 3, 3, 4)
)
console.log(
    solution(3, 4, 2, 3, 3, 1, 1)
)