let ans = 0;
let N,L,R;
function solution(n, l, r) {
    [N,L,R] = [n,l-1,r-1]; 
    recur(1,0,4,"11011");
    return ans;
}

function recur(d, currL, currR, val) {
    if(d>=N) {
        if(L<=currL && currL <= R && L<=currR && currR<=R) ans += val[0] == "1" ? 4 : 0;
        else if(currL<L && L<=currR && currR<=R) for(let i=L%5; i<=currR%5; i++) val[i]=="1" && ans++; 
        else if(L<=currL && currL <= R && currR>R) for(let i=currL%5; i<=R%5; i++) val[i]=="1" && ans++; 
        else if(currL<=L && R<=currR) for(let i=L%5; i<=R%5; i++) val[i]=="1" && ans++;
        return;
    } 
        
    for(let i=currL; i<=currR; i++) {
        let tempL = Math.pow(5,N-d)*i;
        let tempR = tempL + Math.pow(5,N-d)-1;
        if((tempL <L && tempR <L) || (tempL >R && tempR >R)) continue;
        val[i%5]=="1" && recur(d+1, i*5, i*5+4, "11011");
    }
}