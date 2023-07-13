function solution(n, info) {
  let answer = Array(11).fill(0);
  let maxCount = 0;

  function findMaxPoint(apeachCount, ryanCount, usedShots, point, arr) {
    if (n < usedShots) return; // 사용한 화살의 수가 전체 화살수 보다 큰 경우

    if (point > 10) {
      // 10포인트까지 모든 경우를 탐색한 경우
      let diff = ryanCount - apeachCount;
      if (maxCount < diff) {
        // 포인트 차이가 maxCount보다 큰 경우
        arr[10] = n - usedShots;
        maxCount = diff; // 해당 포인트 차이를 maxCount에 저장
        answer = arr; // 해당 경우를 answer에 저장
      }
      return;
    }

    if (n > usedShots) {
      // 라이언이 이겨 포인트를 얻는 경우
      let current = [...arr];
      current[10 - point] = info[10 - point] + 1;
      findMaxPoint(
        apeachCount,
        ryanCount + point,
        usedShots + info[10 - point] + 1,
        point + 1,
        current
      );
    }

    if (info[10 - point] > 0) {
      // 어피치가 이겨 포인트를 얻는 경우
      findMaxPoint(apeachCount + point, ryanCount, usedShots, point + 1, arr);
    } else {
      // 둘다 점수를 얻지 못하는 경우
      findMaxPoint(apeachCount, ryanCount, usedShots, point + 1, arr);
    }
  }

  findMaxPoint(0, 0, 0, 0, answer); // 0포인트 부터 나올수 있는 모든 경우를 탐색한다

  return maxCount <= 0 ? [-1] : answer;
}