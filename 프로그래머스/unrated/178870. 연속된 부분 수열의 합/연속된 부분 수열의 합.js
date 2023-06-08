function solution(sequence, k) {
  let left = 0;
  let right = 0;
  let sum = sequence[0];
  const result = [];

  while (right < sequence.length) {
    if (sum < k) {
      // k보다 작으면 오른쪽 포인터 이동
      right++;
      sum += sequence[right];
    } else if (sum > k) {
      // k보다 크면 왼쪽 포인터 이동
      sum -= sequence[left];
      left++;
    } else {
      // k와 같으면 result에 push
      result.push([left, right]);
      right++; // 다른 값을 구하기 위해 포인터 이동
      sum += sequence[right];
    }
  }

  return result.sort(condition)[0];
}

function condition(a, b) {
  const lenDiff = Math.abs(a[0] - a[1]) - Math.abs(b[0] - b[1]);
  if (lenDiff !== 0) return lenDiff; // 길이에 따라 정렬
  return a[0] - b[0]; // 그 외는 0번째 원소 index가 낮은 순서로 정렬
}