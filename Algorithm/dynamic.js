/*
  길이(i)  0 1 2 3 4  5  6 7  8  9  10
  가격(Pi) 0 1 5 8 9 10 17 17 20 24 30

  길이가 n인 막대기의 최대 가격을 Rn이라고 할 때,
  Rn = max(Pi + Rn-i) 단, i는 1부터 n
  max는 여러 값 중 최대값을 의미

  R4 = max(P1 + R3, P2+R2, P3+R1, P4 + R0)

  P1 = 1, P2 = 5, P3 = 8

  R1 = max(P1 + R0) = 1
  R2 = max(P1 + R1, P2 + R0) = max(2, 5) = 5
  R3 = max(P1 + R2, P2 + R1, P3 + R0) = max(6, 6, 8) = 8
*/

var p = [0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30];
function cutRod(p, n) {
  var r = [0];
  for (var i = 1; i <= n; i++) {
    q = -1;
    for (var j = 1; j <= i; j++) {
      q = Math.max(q, p[j] + r[i - j]);
    }
    r[i] = q;
  }
  return r[n];
}

console.log(cutRod(p, 2)); // 5
console.log(cutRod(p, 3)); // 8
console.log(cutRod(p, 4)); // 10
console.log(cutRod(p, 7)); // 18
