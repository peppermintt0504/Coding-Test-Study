function solution(maps) {
  // 배열 안 문자열을 배열로 변환해준다.
  // ["X591X","X1X5...] -> [["X", "5", "9" ...] ...]
  const newMap = maps.map((n) => n.split(""));

  // 상 하 좌 우 좌표를 미리 셋팅해둔다.
  const dx = [1, 0, -1, 0];
  const dy = [0, 1, 0, -1];

  function DFS(x, y, num) {
    
    // 들어온 num은 현재 String이므로 숫자로 변환해준다.
    let sum = Number(num);

    // 설정해둔 좌표 배열을 통해 상 하 좌 우를 탐색한다.
    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      // 지도를 벗어나지 않는지 판단한다.
      if (nx >= 0 && ny >= 0 && nx < newMap.length && ny < newMap[0].length) {
        
        // 지도를 벗어나지 않고 "X"가 아닌 곳을 찾는다면
        if (newMap[nx][ny] !== "X") {
          
          // 식량 수를 저장하고
          const next = newMap[nx][ny];

          // 그 곳을 "X"로 변환하고
          newMap[nx][ny] = "X";

          // DFS를 통해 그 좌표부터 다시 탐색을 한다.
          // 그리고 그 리턴 값을 sum에 더해준다.
          sum += DFS(nx, ny, next);
        }
      }
    }

    // 최종적으로 다 더해진 sum을 리턴한다.
    return sum;
  }

  const answer = [];

  // 이중 포문을 통해 하나씩 살펴본다.
  for (let i = 0; i < newMap.length; i++) {
    for (let j = 0; j < newMap[0].length; j++) {
      
      // "X"가 아닌 곳을 찾게된다면
      if (newMap[i][j] !== "X") {

        // 일단 현재 수를 저장해둔다.
        const start = newMap[i][j];

        // 그 후 그 곳을 X로 변환한다.
        newMap[i][j] = "X";

        // DFS(x좌표, y좌표, 식량 수)를 실행하고
        // 그에 대한 반환 값을 answer에 push한다.
        answer.push(DFS(i, j, start));
      }
    }
  }

  // 만약 answer의 길이가 0이라면 [-1]을 리턴한다.
  // 아니라면 오름차순으로 정렬 후 리턴해준다.
  return answer.length ? answer.sort((a, b) => a - b) : [-1];
}