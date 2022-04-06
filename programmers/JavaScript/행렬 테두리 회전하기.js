function solution(rows, columns, queries) {
    var answer = [];
    let num = 1;
    let board = Array.from(new Array(rows + 1), () =>
        new Array(columns + 1).fill(0)
    );
    
    //기본 보드 만들기
    for(let i = 1; i<=rows;i++){
        for(let j = 1; j<=columns;j++){
            board[i][j] = (i - 1) * columns + j;
        }
    }
    
    queries.forEach(step=>{
        const [x1,y1,x2,y2] = step;
        const stack = [];
        
        // 맨 위 직사각형 고르기 x1은 행 고정, y1이 y2 직전까지 1씩 증가
        for (let i = y1; i < y2; i++) stack.push(board[x1][i]);
        
        // 오른쪽 직사각형 고르기 y2는 고정, x1이 x2 직전까지 1씩 증가
        for (let i = x1; i < x2; i++) stack.push(board[i][y2]);
        
        // 아래쪽 직사각형 고르기 x2는 고정, y2가 y1 직전까지 1씩 감소
        for (let i = y2; i > y1; i--) stack.push(board[x2][i]);
        
        // 왼쪽 직사각형 고르기y1는 고정, x2가 x1 직전까지 1씩 감소
        for (let i = x2; i > x1; i--) stack.push(board[i][y1]);
        
        // 정답 찾기
        answer.push(Math.min(...stack));
        const temp = stack.pop();
        stack.unshift(temp);

        for (let i = y1; i < y2; i++) board[x1][i] = stack.shift();
        for (let i = x1; i < x2; i++) board[i][y2] = stack.shift();
        for (let i = y2; i > y1; i--) board[x2][i] = stack.shift();
        for (let i = x2; i > x1; i--) board[i][y1] = stack.shift();
    })
    return answer;
}