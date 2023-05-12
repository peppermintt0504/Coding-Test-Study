const gcd = (n1, n2) => {
  let remainder = n1 % n2;
  return n2 === 0 ? n1 : gcd(n2, remainder);
};

function solution(arrayA, arrayB) {
  var answer = 0;
  let [gcdA, gcdB] = [arrayA[0], arrayB[0]];
  for (let i = 1; i < arrayA.length; i++) {
    gcdA = gcd(gcdA, arrayA[i]);
    gcdB = gcd(gcdB, arrayB[i]);
  }
  if (gcdA === 1) gcdA = 0;
  if (gcdB === 1) gcdB = 0;

  if (arrayA.every((v) => v % gcdB !== 0)) answer = Math.max(answer, gcdB);
  if (arrayB.every((v) => v % gcdA !== 0)) answer = Math.max(answer, gcdA);

  return answer;
}